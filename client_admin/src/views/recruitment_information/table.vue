<template>
	<el-main class="bg">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>
				<el-col :xs="24" :sm="24" :lg="8">
					<el-form-item label="企业名称">
						<el-input v-model="query.enterprise_name"></el-input>
					</el-form-item>
				</el-col>
				<el-col :xs="24" :sm="24" :lg="8">
					<el-form-item label="企业行业">
						<el-input v-model="query.enterprise_industry"></el-input>
					</el-form-item>
				</el-col>
				<el-col :xs="24" :sm="24" :lg="8">
					<el-form-item label="工作类型">
						<el-select v-model="query.type_of_work">
                            <el-option v-for="o in list_type_of_work" :key="o" :label="o"
                            	:value="o">
                            </el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :xs="24" :sm="24" :lg="8">
					<el-form-item label="工作省份">
						<el-input v-model="query.working_province"></el-input>
					</el-form-item>
				</el-col>
				<el-col :xs="24" :sm="24" :lg="8">
					<el-form-item label="是否包住">
						<el-select v-model="query.is_it_wrapped">
                            <el-option v-for="o in list_is_it_wrapped" :key="o" :label="o"
                            	:value="o">
                            </el-option>
						</el-select>
					</el-form-item>
				</el-col>

				<el-col :xs="24" :sm="10" :lg="8">
					<el-form-item>
						<el-button type="primary" @click="search()">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/recruitment_information/table','add') || $check_action('/recruitment_information/view','add')" class="el-button el-button--default el-button--primary" to="./view?">添加
						</router-link>
						<el-button v-if="user_group == '管理员' || $check_action('/recruitment_information/table','del') || $check_action('/recruitment_information/view','del')" class="" type="danger" @click="delInfo()">删除</el-button>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
			<el-table-column prop="enterprise_name" label="企业名称"
				v-if="user_group == '管理员' || $check_field('get','enterprise_name')" min-width="200">
			</el-table-column>
			<el-table-column prop="business_address" label="企业地址"
				v-if="user_group == '管理员' || $check_field('get','business_address')" min-width="200">
			</el-table-column>
			<el-table-column prop="enterprise_industry" label="企业行业"
				v-if="user_group == '管理员' || $check_field('get','enterprise_industry')" min-width="200">
			</el-table-column>
			<el-table-column prop="enterprise_picture" label="企业图片"
				v-if="user_group == '管理员' || $check_field('get','enterprise_picture')" min-width="200">
				<template slot-scope="scope">
					<el-image style="width: 100px; height: 100px" :src="$fullUrl(scope.row['enterprise_picture'])"
						:preview-src-list="[$fullUrl(scope.row['enterprise_picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</template>
			</el-table-column>
			<el-table-column prop="person_in_charge" label="负责人"
				v-if="user_group == '管理员' || $check_field('get','person_in_charge')" min-width="200">
				<template slot-scope="scope">
					{{ get_user_person_in_charge(scope.row['person_in_charge']) }}
				</template>
			</el-table-column>
			<el-table-column prop="company_profile" label="企业简介"
				v-if="user_group == '管理员' || $check_field('get','company_profile')" min-width="200">
			</el-table-column>
			<el-table-column prop="professional_requirements" label="专业要求"
				v-if="user_group == '管理员' || $check_field('get','professional_requirements')" min-width="200">
			</el-table-column>
			<el-table-column prop="age_requirements" label="年龄要求"
				v-if="user_group == '管理员' || $check_field('get','age_requirements')" min-width="200">
			</el-table-column>
			<el-table-column prop="character" label="性格"
				v-if="user_group == '管理员' || $check_field('get','character')" min-width="200">
			</el-table-column>
			<el-table-column prop="educational_requirements" label="学历要求"
				v-if="user_group == '管理员' || $check_field('get','educational_requirements')" min-width="200">
			</el-table-column>
			<el-table-column prop="graduation_school_requirements" label="毕业学校要求"
				v-if="user_group == '管理员' || $check_field('get','graduation_school_requirements')" min-width="200">
			</el-table-column>
			<el-table-column prop="recruitment_occupation" label="招聘职业"
				v-if="user_group == '管理员' || $check_field('get','recruitment_occupation')" min-width="200">
			</el-table-column>
			<el-table-column prop="certificate_requirements" label="证书要求"
				v-if="user_group == '管理员' || $check_field('get','certificate_requirements')" min-width="200">
			</el-table-column>
			<el-table-column prop="occupational_category" label="职业类别"
				v-if="user_group == '管理员' || $check_field('get','occupational_category')" min-width="200">
			</el-table-column>
			<el-table-column prop="type_of_work" label="工作类型"
				v-if="user_group == '管理员' || $check_field('get','type_of_work')" min-width="200">
			</el-table-column>
			<el-table-column prop="working_province" label="工作省份"
				v-if="user_group == '管理员' || $check_field('get','working_province')" min-width="200">
			</el-table-column>
			<el-table-column prop="working_years" label="工作年限"
				v-if="user_group == '管理员' || $check_field('get','working_years')" min-width="200">
			</el-table-column>
			<el-table-column prop="a_monthly_salary" label="月薪"
				v-if="user_group == '管理员' || $check_field('get','a_monthly_salary')" min-width="200">
			</el-table-column>
			<el-table-column prop="is_it_wrapped" label="是否包住"
				v-if="user_group == '管理员' || $check_field('get','is_it_wrapped')" min-width="200">
			</el-table-column>
			<el-table-column prop="working_hours" label="工作时间"
				v-if="user_group == '管理员' || $check_field('get','working_hours')" min-width="200">
			</el-table-column>
			<el-table-column prop="compensation_and_benefits" label="薪酬福利"
				v-if="user_group == '管理员' || $check_field('get','compensation_and_benefits')" min-width="200">
			</el-table-column>
			<el-table-column prop="job_description" label="职业描述"
				v-if="user_group == '管理员' || $check_field('get','job_description')" min-width="200">
			</el-table-column>

            <el-table-column sortable prop="create_time" label="创建时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["create_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
            </el-table-column>

			<el-table-column sortable prop="update_time" label="更新时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["update_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/recruitment_information/table','set') || $check_action('/recruitment_information/view','set') || $check_action('/recruitment_information/view','get') || $check_action('/投递简历/table','add') || $check_action('/投递简历/view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/recruitment_information/table','set') || $check_action('/recruitment_information/view','set') || $check_action('/recruitment_information/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>编辑</span>
					</router-link>
				</template>
			</el-table-column>

		</el-table>

		<!-- 分页器 -->
		<div class="mt text_center">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="query.page" :page-sizes="[7, 10, 30, 100]" :page-size="query.size"
				layout="total, sizes, prev, pager, next, jumper" :total="count">
			</el-pagination>
		</div>
		<!-- /分页器 -->

		<div class="modal_wrap" v-if="showModal">
			<div class="modal_box">
				<!-- <div class="modal_box_close" @click="closeModal">X</div> -->
				<p class="modal_box_title">重要提醒</p>
				<p class="modal_box_text">当前有数据达到预警值！</p>
				<div class="btn_box">
					<span @click="closeModal">取消</span>
					<span @click="closeModal">确定</span>
				</div>
			</div>
		</div>


	</el-main>
</template>
<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/recruitment_information/get_list?like=0",
				url_del: "~/api/recruitment_information/del?",

				// 字段ID
				field: "recruitment_information_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
					"enterprise_name": "",
					"enterprise_industry": "",
					"type_of_work": "",
					"working_province": "",
					"is_it_wrapped": "",
					"login_time": "",
					"create_time": "",
				},
				// 数据
				list: [],
				// 用户列表
				list_user_person_in_charge: [],
				// 工作类型列表
				list_type_of_work: ['全职','兼职'],
				// 是否包住列表
				list_is_it_wrapped: ['是','否'],
			}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},
			get_list_before(param){
				var user_group = this.user.user_group;
				if(user_group != "管理员"){
					switch(user_group){
						case "企业用户":
						param["person_in_charge"] = this.user.user_id;
						break;
					}
				}
				return param;
			},

			open_tip() {
				const h = this.$createElement;

				var message = "";
				var list = this.list;

				var ifs = [ ];
				for (var n = 0; n < ifs.length; n++) {
					var o = ifs[n];
					for (var i = 0; i < list.length; i++) {
						var lt = list[i];
						if (o.type == "数内") {
							if ((o.start || o.start === 0) && (o.end || o.end === 0)) {
								if (lt[o.factor] > o.start && lt[o.factor] < o.end) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.start || o.start === 0) {
								if (lt[o.factor] > o.start) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.end || o.end === 0) {
								if (lt[o.factor] < o.end) {
									o["idx"] = o["idx"] + 1;
								}
							}
						} else if (o.type == "数外") {
							if ((o.start || o.start === 0) && (o.end || o.end === 0)) {
								if (lt[o.factor] < o.start || lt[o.factor] > o.end) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.start || o.start === 0) {
								if (lt[o.factor] < o.start) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.end || o.end === 0) {
								if (lt[o.factor] > o.end) {
									o["idx"] = o["idx"] + 1;
								}
							}
						} else if (o.type == "日内") {
							if ((o.start) && (o.end)) {
								if (lt[o.factor] > o.start && lt[o.factor] < o.end) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.start) {
								if (lt[o.factor] < o.start) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.end) {
								if (lt[o.factor] > o.end) {
									o["idx"] = o["idx"] + 1;
								}
							}
						} else if (o.type == "日外") {
							if (o.start && o.end) {
								if (lt[o.factor] < o.start || lt[o.factor] > o.end) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.start) {
								if (lt[o.factor] < o.start) {
									o["idx"] = o["idx"] + 1;
								}
							} else if (o.end) {
								if (lt[o.factor] > o.end) {
									o["idx"] = o["idx"] + 1;
								}
							}
						}
					}

					if (o["idx"]) {
						message += o.title;
						if (o["type"] == "数内") {
							if (o.start || o.start === 0) {
								message += "大于" + o.start;
							}
							if ((o.start || o.start === 0) && (o.end || o.end === 0)) {
								message += "并且";
							}
							if (o.end || o.end === 0) {
								message += "小于" + o.end;
							}
						} else if (o["type"] == "数外") {
							if (o.start || o.start === 0) {
								message += "小于" + o.start;
							}
							if ((o.start || o.start === 0) || (o.end || o.end === 0)) {
								message += "或者";
							}
							if (o.end || o.end === 0) {
								message += "大于" + o.end;
							}
						} else if (o["type"] == "日内") {
							if (o.start) {
								message += "在" + o.start + "之后";
							}
							if (o.start && o.end) {
								message += "并且";
							}
							if (o.end) {
								message += "在" + o.end + "之前";
							}
						} else if (o["type"] == "日外") {
							if (o.start) {
								message += "在" + o.start + "之前";
							}
							if (o.start || o.end) {
								message += "或者";
							}
							if (o.end) {
								message += "在" + o.end + "之后";
							}
						}
						message += "的有" + o["idx"] + "条";
					}
				}

				if (message) {
					message += "，需要处理、请尽快处理。";
					this.showModal = true;
					// this.$notify({
					// 	title: '提醒',
					// 	dangerouslyUseHTMLString: true,
					// 	message: h('i', {
					// 		style: 'color: teal'
					// 	}, message)
					// });
				}
			},
			/**
			 * 获取企业用户用户列表
			 */
			async get_list_user_person_in_charge() {
				var json = await this.$get("~/api/user/get_list?user_group=企业用户");
				if(json.result && json.result.list){
					this.list_user_person_in_charge = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			get_user_person_in_charge(id){
				var obj = this.list_user_person_in_charge.getObj({"user_id":id});
				var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
			deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
			this.get_list_user_person_in_charge();
			setTimeout(() => {
				this.open_tip();
			}, 1000)
		}
	}
</script>

<style type="text/css">
	.bg {
		background: white;
	}

	.form.p_4 {
		padding: 1rem;
	}

	.form .el-input {
		width: initial;
	}

	.mt {
		margin-top: 1rem;
	}

	.text_center {
		text-align: center;
	}

	.float-right {
		float: right;
	}


	.modal_wrap{
		width: 100vw;
		height: 100vh;
		position: fixed;
		top: 0;
		left: 0;
		background: rgba(0,0,0,0.5);
		z-index: 9999999999;
	}
	.modal_wrap .modal_box{
		width: 400px;
		height: 200px;
		background: url("../../assets/modal_bg.jpg") no-repeat center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-left: -200px;
		margin-top: -100px;
		border-radius: 10px;
		}
	.modal_wrap .modal_box .modal_box_close{
		font-size: 20px;
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
		}
	.modal_wrap .modal_box .modal_box_title{
	  text-align: center;
    font-size: 18px;
    margin: 16px auto;
    color: #fff;
    border-bottom: 1px solid rgba(117, 116, 116,0.5);
    padding-bottom: 16px;
    width: 356px;
		}
	.modal_wrap .modal_box .modal_box_text{
			text-align: center;
		font-size: 15px;
		color: #fff;
		margin-top: 25px;
		}
	.modal_wrap .modal_box .btn_box{
		display: flex;
		flex-direction: row;
		justify-content: center;
		margin-top: 42px;
		}
			.modal_wrap .modal_box .btn_box span{
				display: inline-block;
				width: 80px;
				height: 30px;
				line-height: 30px;
				text-align: center;
				border: 1px solid #ccc;
				font-size: 14px;
				cursor: pointer;
				color: #fff;
			}
	.modal_wrap .modal_box .btn_box span:nth-child(2){
		background: #409EFF;
		color: #fff;
		border-color: #409EFF;
		margin-left: 15px;
	}
</style>
