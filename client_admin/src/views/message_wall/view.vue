<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','message_title') || $check_field('add','message_title') || $check_field('set','message_title')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="留言标题" prop="message_title">
					<el-input id="message_title" v-model="form['message_title']" placeholder="请输入留言标题"
							  v-if="user_group === '管理员' || (form['message_wall_id'] && $check_field('set','message_title')) || (!form['message_wall_id'] && $check_field('add','message_title'))" :disabled="disabledObj['message_title_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','message_title')">{{form['message_title']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','message_time') || $check_field('add','message_time') || $check_field('set','message_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="留言时间" prop="message_time">
					<el-date-picker :disabled="disabledObj['message_time_isDisabled']" v-if="user_group === '管理员' || (form['message_wall_id'] && $check_field('set','message_time')) || (!form['message_wall_id'] && $check_field('add','message_time'))" id="message_time"
						v-model="form['message_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','message_time')">{{form['message_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','message_person') || $check_field('add','message_person') || $check_field('set','message_person')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="留言人" prop="message_person">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_message_person(form['message_person']) }}
							<!--<el-input id="business_name" v-model="form['message_person']" placeholder="请输入留言人"-->
							<!--v-if="user_group === '管理员' || (form['message_wall_id'] && $check_field('set','message_person')) || (!form['message_wall_id'] && $check_field('add','message_person'))" :disabled="disabledObj['message_person_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','message_person')">{{form['message_person']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['message_wall_id'] && $check_field('set','message_person')) || (!form['message_wall_id'] && $check_field('add','message_person'))" id="message_person" v-model="form['message_person']" :disabled="disabledObj['message_person_isDisabled']">
								<el-option v-for="o in list_user_message_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','message_person')" id="message_person" v-model="form['message_person']" :disabled="true">
								<el-option v-for="o in list_user_message_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="message_person" v-model="form['message_person']" :disabled="disabledObj['message_person_isDisabled']">
							<el-option v-for="o in list_user_message_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','message_content') || $check_field('add','message_content') || $check_field('set','message_content')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="留言内容" prop="message_content">
					<el-input type="textarea" id="message_content" v-model="form['message_content']" placeholder="请输入留言内容"
						v-if="user_group === '管理员' || (form['message_wall_id'] && $check_field('set','message_content')) || (!form['message_wall_id'] && $check_field('add','message_content'))" :disabled="disabledObj['message_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','message_content')">{{form['message_content']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','cover') || $check_field('add','cover') || $check_field('set','cover')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="封面" prop="cover">
					<el-upload :disabled="disabledObj['cover_isDisabled']" id="cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['message_wall_id'] && $check_field('set','cover')) || (!form['message_wall_id'] && $check_field('add','cover'))">
						<img v-if="form['cover']" :src="$fullUrl(form['cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['cover'])" :preview-src-list="[$fullUrl(form['cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
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
				field: "message_wall_id",
				url_add: "~/api/message_wall/add?",
				url_set: "~/api/message_wall/set?",
				url_get_obj: "~/api/message_wall/get_obj?",
				url_upload: "~/api/message_wall/upload?",

				query: {
					"message_wall_id": 0,
				},

				form: {
					"message_title":'', // 留言标题
					"message_time":'', // 留言时间
					"message_person": 0, // 留言人
					"message_content":'', // 留言内容
					"cover":'', // 封面
					"message_wall_id": 0, // ID

				},
				disabledObj:{
					"message_title_isDisabled": false,
					"message_time_isDisabled": false,
					"message_person_isDisabled": false,
					"message_content_isDisabled": false,
					"cover_isDisabled": false,
				},
				// 用户列表
				list_user_message_person: [],
				// 用户组
				group_user_message_person: "",

			}
		},
		methods: {
			/**
			 * 获取学生用户列表
			 */
			async get_list_user_message_person() {
                // if(this.user_group !== "管理员" && this.form["message_person"] === 0) {
                //     this.form["message_person"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=学生");
                if(json.result && json.result.list){
                    this.list_user_message_person = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			/**
			 * 获取学生用户组
			 */
			async get_group_user_message_person() {
				this.form["message_person"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=学生");
				if(json.result && json.result.obj){
					this.group_user_message_person = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_message_person(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_message_person.source_table+"/get_obj?"
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
									if (arr[i]!=="message_person") {
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
			get_user_message_person(id){
				var obj = this.list_user_message_person.getObj({"user_id":id});
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
			 * 上传封面
			 * @param {Object} param图片参数
			 */
			upload_cover(param){
				this.uploadFile(param.file, "cover");
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
						case "留言人":
							if(param["message_person"] > 0){
								param["message_person"] = this.user.user_id;
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
				this.form["message_time"] = this.$toTime(parseInt(this.form["message_time"]),"yyyy-MM-dd")
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
				if(parseInt(this.form["message_time"]) > 9999){
					this.form["message_time"] = this.$toTime(parseInt(this.form["message_time"]),"yyyy-MM-dd")
				}

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/message_wall/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/message_wall/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/message_wall/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/message_wall/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/message_wall/view','get');
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
			this.get_list_user_message_person();
			this.get_group_user_message_person();
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
