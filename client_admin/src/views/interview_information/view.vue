<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','student') || $check_field('add','student') || $check_field('set','student')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="学生" prop="student">
						<el-select v-if="user_group === '管理员' || (form['interview_information_id'] && $check_field('set','student')) || (!form['interview_information_id'] && $check_field('add','student'))" id="student" v-model="form['student']" :disabled="disabledObj['student_isDisabled']">
							<el-option v-for="o in list_user_student" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','student')" id="student" v-model="form['student']" :disabled="true">
							<el-option v-for="o in list_user_student" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_name') || $check_field('add','enterprise_name') || $check_field('set','enterprise_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业名称" prop="enterprise_name">
					<el-input id="enterprise_name" v-model="form['enterprise_name']" placeholder="请输入企业名称"
							  v-if="user_group === '管理员' || (form['interview_information_id'] && $check_field('set','enterprise_name')) || (!form['interview_information_id'] && $check_field('add','enterprise_name'))" :disabled="disabledObj['enterprise_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','enterprise_name')">{{form['enterprise_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_industry') || $check_field('add','enterprise_industry') || $check_field('set','enterprise_industry')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业行业" prop="enterprise_industry">
					<el-input id="enterprise_industry" v-model="form['enterprise_industry']" placeholder="请输入企业行业"
							  v-if="user_group === '管理员' || (form['interview_information_id'] && $check_field('set','enterprise_industry')) || (!form['interview_information_id'] && $check_field('add','enterprise_industry'))" :disabled="disabledObj['enterprise_industry_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','enterprise_industry')">{{form['enterprise_industry']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','person_in_charge') || $check_field('add','person_in_charge') || $check_field('set','person_in_charge')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="负责人" prop="person_in_charge">
						<el-select v-if="user_group === '管理员' || (form['interview_information_id'] && $check_field('set','person_in_charge')) || (!form['interview_information_id'] && $check_field('add','person_in_charge'))" id="person_in_charge" v-model="form['person_in_charge']" :disabled="disabledObj['person_in_charge_isDisabled']">
							<el-option v-for="o in list_user_person_in_charge" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','person_in_charge')" id="person_in_charge" v-model="form['person_in_charge']" :disabled="true">
							<el-option v-for="o in list_user_person_in_charge" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','invitation_information') || $check_field('add','invitation_information') || $check_field('set','invitation_information')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="邀请信息" prop="invitation_information">
					<el-input type="textarea" id="invitation_information" v-model="form['invitation_information']" placeholder="请输入邀请信息"
						v-if="user_group === '管理员' || (form['interview_information_id'] && $check_field('set','invitation_information')) || (!form['interview_information_id'] && $check_field('add','invitation_information'))" :disabled="disabledObj['invitation_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','invitation_information')">{{form['invitation_information']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "interview_information_id",
				url_add: "~/api/interview_information/add?",
				url_set: "~/api/interview_information/set?",
				url_get_obj: "~/api/interview_information/get_obj?",
				url_upload: "~/api/interview_information/upload?",

				query: {
					"interview_information_id": 0,
				},

				form: {
					"student": 0, // 学生
					"enterprise_name":'', // 企业名称
					"enterprise_industry":'', // 企业行业
					"person_in_charge": 0, // 负责人
					"invitation_information":'', // 邀请信息
					"interview_information_id": 0, // ID

				},
				disabledObj:{
					"student_isDisabled": false,
					"enterprise_name_isDisabled": false,
					"enterprise_industry_isDisabled": false,
					"person_in_charge_isDisabled": false,
					"invitation_information_isDisabled": false,
				},
				// 用户列表
				list_user_student: [],
				// 用户列表
				list_user_person_in_charge: [],

			}
		},
		methods: {
			/**
			 * 获取学生用户列表
			 */
			async get_list_user_student() {
                // if(this.user_group !== "管理员" && this.form["student"] === 0) {
                //     this.form["student"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=学生");
                if(json.result && json.result.list){
                    this.list_user_student = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_student(id){
				var obj = this.list_user_student.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			/**
			 * 获取企业用户用户列表
			 */
			async get_list_user_person_in_charge() {
                // if(this.user_group !== "管理员" && this.form["person_in_charge"] === 0) {
                //     this.form["person_in_charge"] = this.user.user_id;
                // }
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
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "学生":
							if(param["student"] > 0){
								param["student"] = this.user.user_id;
							}
							break;
						case "负责人":
							if(param["person_in_charge"] > 0){
								param["person_in_charge"] = this.user.user_id;
							}
							break;
					}
				}
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							if(dbKey === "charging_standard"){
								this.form['charging_rules'] = form[dbKey];
								this.disabledObj['charging_rules_isDisabled'] = true;
							};
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/interview_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/interview_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/interview_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/interview_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/interview_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_student();
			this.get_list_user_person_in_charge();
		}
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
