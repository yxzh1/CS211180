<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_name') || $check_field('add','enterprise_name') || $check_field('set','enterprise_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业名称" prop="enterprise_name">
					<el-input id="enterprise_name" v-model="form['enterprise_name']" placeholder="请输入企业名称"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_name')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_name'))" :disabled="disabledObj['enterprise_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','enterprise_name')">{{form['enterprise_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','business_address') || $check_field('add','business_address') || $check_field('set','business_address')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业地址" prop="business_address">
					<el-input id="business_address" v-model="form['business_address']" placeholder="请输入企业地址"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','business_address')) || (!form['recruitment_information_id'] && $check_field('add','business_address'))" :disabled="disabledObj['business_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','business_address')">{{form['business_address']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_industry') || $check_field('add','enterprise_industry') || $check_field('set','enterprise_industry')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业行业" prop="enterprise_industry">
					<el-input id="enterprise_industry" v-model="form['enterprise_industry']" placeholder="请输入企业行业"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_industry')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_industry'))" :disabled="disabledObj['enterprise_industry_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','enterprise_industry')">{{form['enterprise_industry']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_picture') || $check_field('add','enterprise_picture') || $check_field('set','enterprise_picture')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业图片" prop="enterprise_picture">
					<el-upload :disabled="disabledObj['enterprise_picture_isDisabled']" id="enterprise_picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_enterprise_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_picture')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_picture'))">
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
						<el-select v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','person_in_charge')) || (!form['recruitment_information_id'] && $check_field('add','person_in_charge'))" id="person_in_charge" v-model="form['person_in_charge']" :disabled="disabledObj['person_in_charge_isDisabled']">
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
			<el-col v-if="user_group === '管理员' || $check_field('get','company_profile') || $check_field('add','company_profile') || $check_field('set','company_profile')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="企业简介" prop="company_profile">
					<el-input type="textarea" id="company_profile" v-model="form['company_profile']" placeholder="请输入企业简介"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','company_profile')) || (!form['recruitment_information_id'] && $check_field('add','company_profile'))" :disabled="disabledObj['company_profile_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','company_profile')">{{form['company_profile']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','professional_requirements') || $check_field('add','professional_requirements') || $check_field('set','professional_requirements')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="专业要求" prop="professional_requirements">
					<el-input id="professional_requirements" v-model="form['professional_requirements']" placeholder="请输入专业要求"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','professional_requirements')) || (!form['recruitment_information_id'] && $check_field('add','professional_requirements'))" :disabled="disabledObj['professional_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','professional_requirements')">{{form['professional_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','age_requirements') || $check_field('add','age_requirements') || $check_field('set','age_requirements')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="年龄要求" prop="age_requirements">
					<el-input id="age_requirements" v-model="form['age_requirements']" placeholder="请输入年龄要求"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','age_requirements')) || (!form['recruitment_information_id'] && $check_field('add','age_requirements'))" :disabled="disabledObj['age_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age_requirements')">{{form['age_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','character') || $check_field('add','character') || $check_field('set','character')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="性格" prop="character">
					<el-input id="character" v-model="form['character']" placeholder="请输入性格"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','character')) || (!form['recruitment_information_id'] && $check_field('add','character'))" :disabled="disabledObj['character_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','character')">{{form['character']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','educational_requirements') || $check_field('add','educational_requirements') || $check_field('set','educational_requirements')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="学历要求" prop="educational_requirements">
					<el-input id="educational_requirements" v-model="form['educational_requirements']" placeholder="请输入学历要求"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','educational_requirements')) || (!form['recruitment_information_id'] && $check_field('add','educational_requirements'))" :disabled="disabledObj['educational_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','educational_requirements')">{{form['educational_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','graduation_school_requirements') || $check_field('add','graduation_school_requirements') || $check_field('set','graduation_school_requirements')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="毕业学校要求" prop="graduation_school_requirements">
					<el-input id="graduation_school_requirements" v-model="form['graduation_school_requirements']" placeholder="请输入毕业学校要求"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','graduation_school_requirements')) || (!form['recruitment_information_id'] && $check_field('add','graduation_school_requirements'))" :disabled="disabledObj['graduation_school_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','graduation_school_requirements')">{{form['graduation_school_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_occupation') || $check_field('add','recruitment_occupation') || $check_field('set','recruitment_occupation')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="招聘职业" prop="recruitment_occupation">
					<el-input id="recruitment_occupation" v-model="form['recruitment_occupation']" placeholder="请输入招聘职业"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','recruitment_occupation')) || (!form['recruitment_information_id'] && $check_field('add','recruitment_occupation'))" :disabled="disabledObj['recruitment_occupation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_occupation')">{{form['recruitment_occupation']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','certificate_requirements') || $check_field('add','certificate_requirements') || $check_field('set','certificate_requirements')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="证书要求" prop="certificate_requirements">
					<el-input id="certificate_requirements" v-model="form['certificate_requirements']" placeholder="请输入证书要求"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','certificate_requirements')) || (!form['recruitment_information_id'] && $check_field('add','certificate_requirements'))" :disabled="disabledObj['certificate_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','certificate_requirements')">{{form['certificate_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','occupational_category') || $check_field('add','occupational_category') || $check_field('set','occupational_category')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="职业类别" prop="occupational_category">
					<el-input id="occupational_category" v-model="form['occupational_category']" placeholder="请输入职业类别"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','occupational_category')) || (!form['recruitment_information_id'] && $check_field('add','occupational_category'))" :disabled="disabledObj['occupational_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','occupational_category')">{{form['occupational_category']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','type_of_work') || $check_field('add','type_of_work') || $check_field('set','type_of_work')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="工作类型" prop="type_of_work">
					<el-select id="type_of_work" v-model="form['type_of_work']"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','type_of_work')) || (!form['recruitment_information_id'] && $check_field('add','type_of_work'))">
						<el-option v-for="o in list_type_of_work" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','type_of_work')">{{form['type_of_work']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','working_province') || $check_field('add','working_province') || $check_field('set','working_province')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="工作省份" prop="working_province">
					<el-input id="working_province" v-model="form['working_province']" placeholder="请输入工作省份"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','working_province')) || (!form['recruitment_information_id'] && $check_field('add','working_province'))" :disabled="disabledObj['working_province_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','working_province')">{{form['working_province']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','working_years') || $check_field('add','working_years') || $check_field('set','working_years')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="工作年限" prop="working_years">
					<el-input id="working_years" v-model="form['working_years']" placeholder="请输入工作年限"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','working_years')) || (!form['recruitment_information_id'] && $check_field('add','working_years'))" :disabled="disabledObj['working_years_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','working_years')">{{form['working_years']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','a_monthly_salary') || $check_field('add','a_monthly_salary') || $check_field('set','a_monthly_salary')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="月薪" prop="a_monthly_salary">
					<el-input id="a_monthly_salary" v-model="form['a_monthly_salary']" placeholder="请输入月薪"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','a_monthly_salary')) || (!form['recruitment_information_id'] && $check_field('add','a_monthly_salary'))" :disabled="disabledObj['a_monthly_salary_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','a_monthly_salary')">{{form['a_monthly_salary']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','is_it_wrapped') || $check_field('add','is_it_wrapped') || $check_field('set','is_it_wrapped')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="是否包住" prop="is_it_wrapped">
					<el-select id="is_it_wrapped" v-model="form['is_it_wrapped']"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','is_it_wrapped')) || (!form['recruitment_information_id'] && $check_field('add','is_it_wrapped'))">
						<el-option v-for="o in list_is_it_wrapped" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','is_it_wrapped')">{{form['is_it_wrapped']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','working_hours') || $check_field('add','working_hours') || $check_field('set','working_hours')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="工作时间" prop="working_hours">
					<el-input id="working_hours" v-model="form['working_hours']" placeholder="请输入工作时间"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','working_hours')) || (!form['recruitment_information_id'] && $check_field('add','working_hours'))" :disabled="disabledObj['working_hours_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','working_hours')">{{form['working_hours']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','compensation_and_benefits') || $check_field('add','compensation_and_benefits') || $check_field('set','compensation_and_benefits')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="薪酬福利" prop="compensation_and_benefits">
					<el-input id="compensation_and_benefits" v-model="form['compensation_and_benefits']" placeholder="请输入薪酬福利"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','compensation_and_benefits')) || (!form['recruitment_information_id'] && $check_field('add','compensation_and_benefits'))" :disabled="disabledObj['compensation_and_benefits_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','compensation_and_benefits')">{{form['compensation_and_benefits']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','job_description') || $check_field('add','job_description') || $check_field('set','job_description')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="职业描述" prop="job_description">
					<el-input type="textarea" id="job_description" v-model="form['job_description']" placeholder="请输入职业描述"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','job_description')) || (!form['recruitment_information_id'] && $check_field('add','job_description'))" :disabled="disabledObj['job_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','job_description')">{{form['job_description']}}</div>
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
				field: "recruitment_information_id",
				url_add: "~/api/recruitment_information/add?",
				url_set: "~/api/recruitment_information/set?",
				url_get_obj: "~/api/recruitment_information/get_obj?",
				url_upload: "~/api/recruitment_information/upload?",

				query: {
					"recruitment_information_id": 0,
				},

				form: {
					"enterprise_name":'', // 企业名称
					"business_address":'', // 企业地址
					"enterprise_industry":'', // 企业行业
					"enterprise_picture":'', // 企业图片
					"person_in_charge": 0, // 负责人
					"company_profile":'', // 企业简介
					"professional_requirements":'', // 专业要求
					"age_requirements":'', // 年龄要求
					"character":'', // 性格
					"educational_requirements":'', // 学历要求
					"graduation_school_requirements":'', // 毕业学校要求
					"recruitment_occupation":'', // 招聘职业
					"certificate_requirements":'', // 证书要求
					"occupational_category":'', // 职业类别
					"type_of_work":'', // 工作类型
					"working_province":'', // 工作省份
					"working_years":'', // 工作年限
					"a_monthly_salary":'', // 月薪
					"is_it_wrapped":'', // 是否包住
					"working_hours":'', // 工作时间
					"compensation_and_benefits":'', // 薪酬福利
					"job_description":'', // 职业描述
					"recruitment_information_id": 0, // ID

				},
				disabledObj:{
					"enterprise_name_isDisabled": false,
					"business_address_isDisabled": false,
					"enterprise_industry_isDisabled": false,
					"enterprise_picture_isDisabled": false,
					"person_in_charge_isDisabled": false,
					"company_profile_isDisabled": false,
					"professional_requirements_isDisabled": false,
					"age_requirements_isDisabled": false,
					"character_isDisabled": false,
					"educational_requirements_isDisabled": false,
					"graduation_school_requirements_isDisabled": false,
					"recruitment_occupation_isDisabled": false,
					"certificate_requirements_isDisabled": false,
					"occupational_category_isDisabled": false,
					"type_of_work_isDisabled": false,
					"working_province_isDisabled": false,
					"working_years_isDisabled": false,
					"a_monthly_salary_isDisabled": false,
					"is_it_wrapped_isDisabled": false,
					"working_hours_isDisabled": false,
					"compensation_and_benefits_isDisabled": false,
					"job_description_isDisabled": false,
				},
				// 用户列表
				list_user_person_in_charge: [],
				//工作类型选项列表
				list_type_of_work: ['全职','兼职'],
				//是否包住选项列表
				list_is_it_wrapped: ['是','否'],

			}
		},
		methods: {
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
					bl = this.$check_action('/recruitment_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','get');
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
