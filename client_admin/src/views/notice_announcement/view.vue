<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','announcement_title') || $check_field('add','announcement_title') || $check_field('set','announcement_title')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="公告标题" prop="announcement_title">
					<el-input id="announcement_title" v-model="form['announcement_title']" placeholder="请输入公告标题"
							  v-if="user_group === '管理员' || (form['notice_announcement_id'] && $check_field('set','announcement_title')) || (!form['notice_announcement_id'] && $check_field('add','announcement_title'))" :disabled="disabledObj['announcement_title_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','announcement_title')">{{form['announcement_title']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','announcement_no') || $check_field('add','announcement_no') || $check_field('set','announcement_no')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="公告编号" prop="announcement_no">
					<el-input id="announcement_no" v-model="form['announcement_no']" placeholder="请输入公告编号"
							  v-if="user_group === '管理员' || (form['notice_announcement_id'] && $check_field('set','announcement_no')) || (!form['notice_announcement_id'] && $check_field('add','announcement_no'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','announcement_no')">{{form['announcement_no']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','release_time') || $check_field('add','release_time') || $check_field('set','release_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="发布时间" prop="release_time">
					<el-date-picker :disabled="disabledObj['release_time_isDisabled']" v-if="user_group === '管理员' || (form['notice_announcement_id'] && $check_field('set','release_time')) || (!form['notice_announcement_id'] && $check_field('add','release_time'))" id="release_time"
						v-model="form['release_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','release_time')">{{form['release_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','announcement_content') || $check_field('add','announcement_content') || $check_field('set','announcement_content')" :xs="24" :sm="24" :lg="24">
				<el-form-item label="公告内容" prop="announcement_content">
					<quill-editor v-model.number="form['announcement_content']"
						v-if="user_group === '管理员' || (form['notice_announcement_id'] && $check_field('set','announcement_content')) || (!form['notice_announcement_id'] && $check_field('add','announcement_content')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','announcement_content')" v-html="form['announcement_content']"></div>
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
				field: "notice_announcement_id",
				url_add: "~/api/notice_announcement/add?",
				url_set: "~/api/notice_announcement/set?",
				url_get_obj: "~/api/notice_announcement/get_obj?",
				url_upload: "~/api/notice_announcement/upload?",

				query: {
					"notice_announcement_id": 0,
				},

				form: {
					"announcement_title":'', // 公告标题
					"announcement_no":this.$get_stamp(), // 公告编号
					"release_time":'', // 发布时间
					"announcement_content":'', // 公告内容
					"notice_announcement_id": 0, // ID

				},
				disabledObj:{
					"announcement_title_isDisabled": false,
					"announcement_no_isDisabled": false,
					"release_time_isDisabled": false,
					"announcement_content_isDisabled": false,
				},

			}
		},
		methods: {

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
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
				this.form["release_time"] = this.$toTime(parseInt(this.form["release_time"]),"yyyy-MM-dd")
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
				if(parseInt(this.form["release_time"]) > 9999){
					this.form["release_time"] = this.$toTime(parseInt(this.form["release_time"]),"yyyy-MM-dd")
				}

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/notice_announcement/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/notice_announcement/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/notice_announcement/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/notice_announcement/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/notice_announcement/view','get');
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
