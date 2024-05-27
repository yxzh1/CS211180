<template>
	<div>
		<el-form-item v-if="$check_register_field('add','gender','/teacher/view')" label="性别" prop="gender">
		<el-select id="gender" v-model="form['gender']">
			<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
		</el-form-item>

	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
						"gender":'',
					}
				}
			},

		},
		data() {
			return {
				field: "teacher_id",
				url_add: "~/api/teacher/add?",
				url_set: "~/api/teacher/set?",
				url_upload: "~/api/teacher/upload?",
				list_gender: ['男','女'],

				rules: {
					"gender": [ ],
				}

			}
		},
		methods: {

		},
		created() {
		}
	}
</script>
