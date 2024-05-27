<template>
	<div class="diy_edit page_resume_information" id="resume_information_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row'>
					<div class="col-12 col-md-6">
						<div class="diy_title">
							<span>企业名称:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
<!--							<input type="text" id="form_enterprise_name" v-model="form['enterprise_name']" placeholder="请输入企业名称" v-if="(form['enterprise_name'] && $check_field('set','enterprise_name')) || (!form['enterprise_name'] && $check_field('add','enterprise_name'))"  :disabled="disabledObj['enterprise_name_isDisabled']"/>-->
<!--							<span v-else-if="$check_field('get','enterprise_name')">{{ form[''] }}</span>-->
							<span >{{ form['enterprise_name'] }}</span>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="diy_title">
							<span>企业行业:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
<!--							<input type="text" id="form_enterprise_industry" v-model="form['enterprise_industry']" placeholder="请输入企业行业" v-if="(form['enterprise_industry'] && $check_field('set','enterprise_industry')) || (!form['enterprise_industry'] && $check_field('add','enterprise_industry'))"  :disabled="disabledObj['enterprise_industry_isDisabled']"/>-->
<!--							<span v-else-if="$check_field('get','enterprise_industry')">{{ form[''] }}</span>-->
							<span >{{ form['enterprise_industry'] }}</span>
						</div>
					</div>
<!--					<div class="col-12 col-md-6">-->
<!--						<div class="diy_title">-->
<!--							<span>学生:-->
<!--							</span>-->
<!--						</div>-->
<!--						<div class="diy_field diy_down">-->
<!--							<select id="form_student" :disabled="disabledObj['student_isDisabled']" v-model="form['student']" v-if="(form['student'] && $check_field('set','student')) || (!form['student'] && $check_field('add','student'))" >-->
<!--								<option v-for="o in list_user_student" :value="o['user_id']">-->
<!--									{{o['nickname'] + '-' + o['username']}}-->
<!--								</option>-->
<!--							</select>-->
<!--							<span v-else-if="$check_field('get','student')">{{ form['student'] }}</span>-->
<!--						</div>-->
<!--					</div>-->
					<div class="col-12 col-md-6">
						<div class="diy_title">
							<span>学生简历:
							</span>
						</div>

            <div>
              <!-- 文件 -->
              <input type="file" style="display: none;" id="form_file_student_resume" title="student_resume"
                     @change="change_file($event.target.files,'student_resume')"/>

              <div v-if="form['student_resume']">
                {{ form['student_resume'].substring(form['student_resume'].lastIndexOf('/') + 1) != null ? form['student_resume'].substring(form['student_resume'].lastIndexOf('/') + 1) : '无'}}
                <button class="btn_submit" onclick="document.getElementById('form_file_student_resume').click()">上传简历</button>
              </div>
            </div>

				<!-- 修改权限 -->
<!--						<div class="diy_field diy_img" v-if="form['student_resume'] && $check_field('set','student_resume')">-->
<!--						<div class="diy_field diy_img" v-if="form['student_resume']">-->
<!--							<label for="form_file_student_resume">-->
<!--								&lt;!&ndash;<span>{{form['student_resume']}} </span>&ndash;&gt;-->
<!--								<a :href="$fullUrl(form['student_resume'])" target="_blank" style="color: rgb(64, 158, 255);">点击下载</a>-->
<!--							</label>-->
<!--						</div>-->
<!--						&lt;!&ndash; 添加权限 &ndash;&gt;-->
<!--&lt;!&ndash;						<div class="diy_field diy_img" v-else-if="!form['student_resume'] && $check_field('add','student_resume')">&ndash;&gt;-->
<!--						<div class="diy_field diy_img" v-else-if="!form['student_resume'] && $check_field('add','student_resume')">-->
<!--							<label for="form_file_student_resume">-->
<!--								<div class="btn_add_img">-->
<!--									<span>+</span>-->
<!--								</div>-->
<!--							</label>-->
<!--						</div>-->
<!--						&lt;!&ndash; 查询权限 &ndash;&gt;-->
<!--						<div class="diy_field diy_img" v-else-if="$check_field('get','student_resume')">-->
<!--							<span>{{form['student_resume']}} </span>-->
<!--						</div>-->

					</div>

					<div class="col-12 col-md-6">
						<div class="diy_title">
							<span>负责人:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_person_in_charge" :disabled="disabledObj['person_in_charge_isDisabled']" v-model="form['person_in_charge']" v-if="(form['person_in_charge'] && $check_field('set','person_in_charge')) || (!form['person_in_charge'] && $check_field('add','person_in_charge'))" >
								<option v-for="o in list_user_person_in_charge" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','person_in_charge')">{{ form['person_in_charge'] }}</span>
						</div>
					</div>
					
				</div>
				<div class="row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()" style="position: relative; left: 450px;">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/resume_information/get_obj?",
				url_add: "~/api/resume_information/add?",
				url_set: "~/api/resume_information/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
					"enterprise_name": "",
					"enterprise_industry": "",
					"student": 0,
					"student_resume": "",
					"person_in_charge": 0,
					"resume_information_id": 0,
				},

				obj: {
					"enterprise_name":'', // 企业名称
					"enterprise_industry":'', // 企业行业
					"student": 0, // 学生
					"student_resume":'', // 学生简历
					"person_in_charge": 0, // 负责人
					"resume_information_id": 0,
				},

				// 表单字段
				form: {
					"enterprise_name":'', // 企业名称
					"enterprise_industry":'', // 企业行业
					"student": 0, // 学生
					"student_resume":'', // 学生简历
					"person_in_charge": 0, // 负责人
					"resume_information_id": 0,
					
				},
				disabledObj:{
					"enterprise_name_isDisabled": false,
					"enterprise_industry_isDisabled": false,
					"student_isDisabled": false,
					"student_resume_isDisabled": false,
					"person_in_charge_isDisabled": false,
				},
				// 用户列表
				list_user_student: [],
				// 用户列表
				list_user_person_in_charge: [],

				// ID字段
				field: "resume_information_id",
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
			async get_user_session_student(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=学生");
				if(json.result && json.result.obj){
					// var source_table = json.result.obj.source_table;
          var source_table = 'resume_information'
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"student":_this.$store.state.user.user_id}, function(res) {
              console.log("res---->",res.result.obj)
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["student"] = user_id
								_this.disabledObj['student' + '_isDisabled'] = true
                console.log("arr----->",arr)
                console.log("arrForm----->",arrForm)
								for (var i=0;i<arr.length;i++){
									for (var j=0;j<arrForm.length;j++){
										if (arr[i]===arrForm[j]){
											if (arr[i]!=="student") {
												_this.form[arrForm[j]] = res.result.obj[arr[i]]
												_this.disabledObj[arrForm[j] + '_isDisabled'] = true
												break;
											}
										}
									}
								}
                console.log("form---->",_this.form)
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
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
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/resume_information/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				if (form) {
					this.obj = $.push(this.obj ,form);
					this.form = $.push(this.form ,form);
				}
				var arr = []
				for (let key in form) {
					arr.push(key)
				}
				for (var i=0;i<arr.length;i++){
					this.disabledObj[arr[i] + '_isDisabled'] = true
				}
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				var form = $.db.get("form");
				var obj = Object.assign({} ,form ,this.obj);
				if (form) {
					this.obj = $.push(this.obj ,obj);
				}
				if (form) {
					this.form = $.push(this.form ,form);
				}
				if(func){
					func(json);
				}
			},

		},
		created() {
			this.get_user_session_student();
			this.get_list_user_student();
			this.get_list_user_person_in_charge();
		}
	}
</script>

<style>
</style>
