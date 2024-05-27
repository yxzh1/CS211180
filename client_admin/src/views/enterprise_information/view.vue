<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_name') || $check_field('add','enterprise_name') || $check_field('set','enterprise_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业名称" prop="enterprise_name">
					<el-input id="enterprise_name" v-model="form['enterprise_name']" placeholder="请输入企业名称"
							  v-if="user_group === '管理员' || (form['enterprise_information_id'] && $check_field('set','enterprise_name')) || (!form['enterprise_information_id'] && $check_field('add','enterprise_name'))" :disabled="disabledObj['enterprise_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','enterprise_name')">{{form['enterprise_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','business_address') || $check_field('add','business_address') || $check_field('set','business_address')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业地址" prop="business_address">
					<el-input id="business_address" v-model="form['business_address']" placeholder="请输入企业地址"
							  v-if="user_group === '管理员' || (form['enterprise_information_id'] && $check_field('set','business_address')) || (!form['enterprise_information_id'] && $check_field('add','business_address'))" :disabled="disabledObj['business_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','business_address')">{{form['business_address']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_industry') || $check_field('add','enterprise_industry') || $check_field('set','enterprise_industry')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业行业" prop="enterprise_industry">
					<el-select id="enterprise_industry" v-model="form['enterprise_industry']"
						v-if="user_group === '管理员' || (form['enterprise_information_id'] && $check_field('set','enterprise_industry')) || (!form['enterprise_information_id'] && $check_field('add','enterprise_industry'))">
						<el-option v-for="o in list_enterprise_industry" :key="o['industry_name']" :label="o['industry_name']"
							:value="o['industry_name']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','enterprise_industry')">{{form['enterprise_industry']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','company_profile') || $check_field('add','company_profile') || $check_field('set','company_profile')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业简介" prop="company_profile">
					<el-input type="textarea" id="company_profile" v-model="form['company_profile']" placeholder="请输入企业简介"
						v-if="user_group === '管理员' || (form['enterprise_information_id'] && $check_field('set','company_profile')) || (!form['enterprise_information_id'] && $check_field('add','company_profile'))" :disabled="disabledObj['company_profile_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','company_profile')">{{form['company_profile']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_picture') || $check_field('add','enterprise_picture') || $check_field('set','enterprise_picture')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业图片" prop="enterprise_picture">
					<el-upload :disabled="disabledObj['enterprise_picture_isDisabled']" id="enterprise_picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_enterprise_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['enterprise_information_id'] && $check_field('set','enterprise_picture')) || (!form['enterprise_information_id'] && $check_field('add','enterprise_picture'))">
						<img v-if="form['enterprise_picture']" :src="$fullUrl(form['enterprise_picture'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','enterprise_picture')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['enterprise_picture'])" :preview-src-list="[$fullUrl(form['enterprise_picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','person_in_charge') || $check_field('add','person_in_charge') || $check_field('set','person_in_charge')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="负责人" prop="person_in_charge">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_person_in_charge(form['person_in_charge']) }}
							<!--<el-input id="business_name" v-model="form['person_in_charge']" placeholder="请输入负责人"-->
							<!--v-if="user_group === '管理员' || (form['enterprise_information_id'] && $check_field('set','person_in_charge')) || (!form['enterprise_information_id'] && $check_field('add','person_in_charge'))" :disabled="disabledObj['person_in_charge_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','person_in_charge')">{{form['person_in_charge']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['enterprise_information_id'] && $check_field('set','person_in_charge')) || (!form['enterprise_information_id'] && $check_field('add','person_in_charge'))" id="person_in_charge" v-model="form['person_in_charge']" :disabled="disabledObj['person_in_charge_isDisabled']">
								<el-option v-for="o in list_user_person_in_charge" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','person_in_charge')" id="person_in_charge" v-model="form['person_in_charge']" :disabled="true">
								<el-option v-for="o in list_user_person_in_charge" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="person_in_charge" v-model="form['person_in_charge']" :disabled="disabledObj['person_in_charge_isDisabled']">
							<el-option v-for="o in list_user_person_in_charge" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
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
				field: "enterprise_information_id",
				url_add: "~/api/enterprise_information/add?",
				url_set: "~/api/enterprise_information/set?",
				url_get_obj: "~/api/enterprise_information/get_obj?",
				url_upload: "~/api/enterprise_information/upload?",

				query: {
					"enterprise_information_id": 0,
				},

				form: {
					"enterprise_name":'', // 企业名称
					"business_address":'', // 企业地址
					"enterprise_industry":'', // 企业行业
					"company_profile":'', // 企业简介
					"enterprise_picture":'', // 企业图片
					"person_in_charge": 0, // 负责人
					"enterprise_information_id": 0, // ID

				},
				disabledObj:{
					"enterprise_name_isDisabled": false,
					"business_address_isDisabled": false,
					"enterprise_industry_isDisabled": false,
					"company_profile_isDisabled": false,
					"enterprise_picture_isDisabled": false,
					"person_in_charge_isDisabled": false,
				},
				//企业行业选项列表
				list_enterprise_industry: [],
				// 用户列表
				list_user_person_in_charge: [],
				// 用户组
				group_user_person_in_charge: "",

			}
		},
		methods: {
			/**
			 * 获取企业行业列表
			 */
			async get_list_enterprise_industry() {
				var json = await this.$get("~/api/industry_management/get_list?");
				if(json.result && json.result.list){
					this.list_enterprise_industry = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			/**
			 * 上传企业图片
			 * @param {Object} param图片参数
			 */
			upload_enterprise_picture(param){
				this.uploadFile(param.file, "enterprise_picture");
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
			/**
			 * 获取企业用户用户组
			 */
			async get_group_user_person_in_charge() {
				this.form["person_in_charge"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=企业用户");
				if(json.result && json.result.obj){
					this.group_user_person_in_charge = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_person_in_charge(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_person_in_charge.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="person_in_charge") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
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
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
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
					bl = this.$check_action('/enterprise_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/enterprise_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/enterprise_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/enterprise_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/enterprise_information/view','get');
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
			this.get_list_enterprise_industry();
			this.get_list_user_person_in_charge();
			this.get_group_user_person_in_charge();
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
