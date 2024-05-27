<template>
	<div>
		<b-form-group id="input-group-0" label="性别" label-for="input-0">
			<b-form-select id="input-0" v-model="form['gender']" :options="getDropList(list_gender)"></b-form-select>
		</b-form-group>
		<b-form-group id="input-group-1" label="个人简介" label-for="input-1">
			<b-form-input id="input-1" v-model="form['personal_profile']" type="text" placeholder="个人简介" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-2" label="姓名" label-for="input-2">
			<b-form-input id="input-2" v-model="form['full_name']" type="text" placeholder="姓名" trim></b-form-input>
		</b-form-group>
		
		<b-form-group id="input-group-4" label="年龄" label-for="input-4">
			<b-form-input id="input-4" v-model="form['age']" type="text" placeholder="年龄" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-5" label="专业" label-for="input-5">
			<b-form-input id="input-5" v-model="form['major']" type="text" placeholder="专业" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-6" label="户籍地" label-for="input-6">
			<b-form-input id="input-6" v-model="form['registered_residence']" type="text" placeholder="户籍地" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-7" label="民族" label-for="input-7">
			<b-form-input id="input-7" v-model="form['nation']" type="text" placeholder="民族" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-8" label="学历" label-for="input-8">
			<b-form-input id="input-8" v-model="form['education']" type="text" placeholder="学历" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-9" label="毕业学校" label-for="input-9">
			<b-form-input id="input-9" v-model="form['graduation_school']" type="text" placeholder="毕业学校" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-10" label="身份证号" label-for="input-10">
			<b-form-input id="input-10" v-model="form['id_number']" type="text" placeholder="身份证号" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-11" label="获奖情况" label-for="input-11">
			<b-form-input id="input-11" v-model="form['awards']" type="text" placeholder="获奖情况" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-12" label="就业意向" label-for="input-12">
			<b-form-input id="input-12" v-model="form['employment_intention']" type="text" placeholder="就业意向" trim></b-form-input>
		</b-form-group>
		<b-form-group id="input-group-13" label="社会实践" label-for="input-13">
			<b-form-input id="input-13" v-model="form['social_practice']" type="text" placeholder="社会实践" trim></b-form-input>
		</b-form-group>
	</div>
</template>

<script>


	export default {

		model: {
			prop: "form",
			event: "change"
		},
		props: {
			form: {
				type: Object,
				default: () => {
					return {

					}
				}
			}
		},
		data(){
			return {
				url_upload: "~/api/student/upload?",
						list_gender: "男,女",
			}
		},
		methods: {
			// 下拉数据列表转换
			getDropList(e){
				let resultArr = [];
				if(e){
					let arr = e.split(",");
					arr.forEach(item => {
						resultArr.push({
								value: item,
						text: item
						})
					});
				}
				return resultArr;
			},
			/**
			 * 上传图片
			 * @param {Object} file 文件对象
			 * @param {key} 保存键名
			 */
			uploadFile(file, key = "img") {
				var _this = this;
				var form = new FormData() // FormData 对象
				form.append('file', file[0]) // 文件对象
				this.$upload(this.url_upload, form, function(json) {
					if (json.result) {
						// _this.form[key] = json.result.url;
						_this.$delete(_this.form,key);
						_this.$set(_this.form,key,json.result.url);
						console.log(_this.form[key])
					} else {
						_this.$toast('上传失败！');
					}
				});
			},
		}
	}
</script>

<style>
</style>
