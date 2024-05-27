<template>
	<div>
		<el-form-item v-if="$check_register_field('add','gender','/enterprise_users/view')" label="性别" prop="gender">
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
				field: "enterprise_users_id",
				url_add: "~/api/enterprise_users/add?",
				url_set: "~/api/enterprise_users/set?",
				url_upload: "~/api/enterprise_users/upload?",
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
