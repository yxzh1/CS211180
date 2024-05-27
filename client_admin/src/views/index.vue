<template>
	<div class="page_root" id="root_index">
		<div class="warp">
			<div class="container-fluid">
				<el-row>
					<el-col :span="4">
						<mm_label bg_color="bg_purple" icon="el-icon-user-solid" :url="url_user_count" unit="人"
								  title="用户数量"></mm_label>
					</el-col>
				</el-row>

				<el-row>
					<el-col v-if="user_group == '管理员' || $check_figure('/contract_agreement/table')" :span="8">
						<div class="card chart">
							<pieChart v-if="list_contract_agreement.length" id="list_contract_agreement" :list="list_contract_agreement" :title="'学生就业查询统计'"></pieChart>
							<div v-if="!list_contract_agreement.length">学生就业没有符合条件的数据</div>
						</div>
					</el-col>
					<el-col v-if="user_group == '管理员' || $check_figure('/student/table')" :span="8">
						<div class="card chart">
							<pieChart v-if="list_student.length" id="list_student" :list="list_student" :title="'学生性别统计'"></pieChart>
							<div v-if="!list_student.length">学生没有符合条件的数据</div>
						</div>
					</el-col>
					<el-col v-if="user_group == '管理员' || $check_figure('/student_work_province/table')" :span="8">
						<div class="card chart">
							<newBarChart v-if="bar_obj_student_work_province.values.length > 0" id="bar_obj_student_work_province" :vm="bar_obj_student_work_province" :title="'学生工作省份统计'">
							</newBarChart>
							<div v-if="!bar_obj_student_work_province.values.length">学生工作省份没有符合条件的数据</div>
						</div>
					</el-col>
				</el-row>
			</div>
		</div>
	</div>
</template>
<script>
	import mixin from "@/mixins/page.js";
	import pieChart from "@/components/charts/pie_chart";
	import barChart from "@/components/charts/bar_chart";
	import newBarChart from "@/components/charts/new_bar_chart";
	import lineChart from "@/components/charts/line_chart";
	import newLineChart from "@/components/charts/new_line_chart";
	import mm_label from "@/components/mm_label.vue";
	export default {
		mixins: [mixin],
		name: "Home",
		components: {
			pieChart,
			barChart,
			newBarChart,
			lineChart,
			newLineChart,
			mm_label
		},
		data() {
			return {
				isAdmin: false,
				recognitionType: "",
				activeName: "third",
				list_contract_agreement: [],
				list_student: [],
				bar_obj_student_work_province: {
					names:[],
					xAxis: [],
					values:[]
				},
				url_user_count: "~/api/user/count?",
			};
		},
		created() {
			this.getUserInfo();
			// 执行合同协议数据获取
			this.get_list_contract_agreement();
			// 执行学生数据获取
			this.get_list_student();
			// 执行学生工作省份数据获取
			this.get_list_student_work_province();
			
			
		},
		mounted() {},
		methods: {
			async get_nickname(list,flag){
				if (flag) {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i],
								null,
								(json) => {
									if (json.result) {
										list[i] = json.result.obj.nickname;
									}
								});
					}
				}else {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i].name,
								null,
								(json) => {
									if (json.result) {
										list[i].name = json.result.obj.nickname;
									}
								});
					}
				}
			},
			// 获取合同协议统计图数据
			get_list_contract_agreement() {
				let data = {};
				let flag = false;
				let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
					if (user_group=="学生"){
						data.student = user_id;
					}
					if (user_group=="企业用户"){
						data.person_in_charge = user_id;
					}
				}
				this.$get("~/api/contract_agreement/list_group?groupby=enterprise_industry", data, (json) => {
					if (json.result) {
						var list = json.result.list;
						this.list_contract_agreement = list.map((o) => {
							return {
								name: o[1],
								value: o[0]
							};
						});
						if (flag){
							this.get_nickname(this.list_contract_agreement,false);
						}
					}
				});
			},
			// 获取学生统计图数据
			get_list_student() {
				let data = {};
				let flag = false;
				this.$get("~/api/student/list_group?groupby=gender", data, (json) => {
					if (json.result) {
						var list = json.result.list;
						this.list_student = list.map((o) => {
							return {
								name: o[1],
								value: o[0]
							};
						});
						if (flag){
							this.get_nickname(this.list_student,false);
						}
					}
				});
			},
			// 获取学生工作省份统计柱状图
			async get_list_student_work_province() {
				let name_list = [];
				let query_str = "";
				let group_by_value = "province_name";
				let flag = false;
				let date_flag = "其他"
				name_list.push("学生数量");
				query_str = query_str+"number_of_students"+","
				this.bar_obj_student_work_province.names = name_list
				query_str = query_str.substr(0,query_str.length-1);
				let data = {};
				await this.$get(
						"~/api/student_work_province/bar_group?field="+query_str+"&groupby="+group_by_value,
						data,
						(json) => {
							if (json.result) {
								let xAxis = [];
								let values = [];
								json.result.list.map((o) => {
									if (date_flag === "日期") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd"));
									}else if (date_flag === "时间") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd hh:mm:ss"));
									}else {
										xAxis.push(o[0]);
									}
									values.push(o.splice(1))
								});
								this.bar_obj_student_work_province.xAxis = xAxis;
								this.bar_obj_student_work_province.values = values;
							}
							if (flag){
								this.get_nickname(this.bar_obj_student_work_province.xAxis,true);
							}
						});
			},
				getUserInfo(){
					let userGroup = window.localStorage.getItem('user_group');
						if(userGroup){
						let _userGroup =JSON.parse(userGroup);
						let _info = JSON.parse(_userGroup.value);
						this.isAdmin = _info["user_group"] == "管理员" ? true : false;
					}
			}

		},
		computed:{
			recognitionHeight(){
				if(this.recognitionType === "face"){
					return "1070px"
				}else{
					return "1180px"
				}
			},
			recognitionUrl(){
					if(this.recognitionType === "face"){
					return "https://www.sk-ai.com/Experience/face-compare"
				}else{
					return "https://www.sk-ai.com/Experience/recognition?type="
				}
			}
		}
	};
</script>

<style scoped="scoped">
	.chart {
		display: block;
		width: 100%;
		height: 400px;
		padding: 1rem;
		position: relative;
	}

	.el-col {
		padding: 0.5rem;
	}

	.card {
		overflow: hidden;
	}
	
	.iframe_box ,.iframe_box_change{
		width: 100%;
		height: 1180px;
		position: relative;
		margin-top: 25px;
	}
	.iframe_box_change{
		height: 580px;
		padding-top: 50px;
	}
.iframe_box	.iframe_box_content, .iframe_box_change .iframe_box_content{
	width: 100%;
	height: 100%;
}
.iframe_box_top{
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100px;
	font-size: 25px;
	line-height: 100px;
	background: #fff;
	z-index: 99999999;
	padding-left: 50px;
}
</style>
