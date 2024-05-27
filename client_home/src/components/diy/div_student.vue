<template>
	<div class="diy_details diy_div_student">
		<div class="warp">
			<div class="container">
				<div class="row">
				<div class="col-12 col-md-6" v-if="$check_field('get','gender')">
					<div class="view">
						<div class="diy_title">
							<span>性别</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["gender"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','personal_profile')">
					<div class="view">
						<div class="diy_title">
							<span>个人简介</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["personal_profile"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','full_name')">
					<div class="view">
						<div class="diy_title">
							<span>姓名</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["full_name"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','certificate')">
					<div class="view">
						<div class="diy_title">
							<span>证书</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(obj['certificate'])" />
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','age')">
					<div class="view">
						<div class="diy_title">
							<span>年龄</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["age"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','major')">
					<div class="view">
						<div class="diy_title">
							<span>专业</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["major"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','registered_residence')">
					<div class="view">
						<div class="diy_title">
							<span>户籍地</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["registered_residence"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','nation')">
					<div class="view">
						<div class="diy_title">
							<span>民族</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["nation"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','education')">
					<div class="view">
						<div class="diy_title">
							<span>学历</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["education"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','graduation_school')">
					<div class="view">
						<div class="diy_title">
							<span>毕业学校</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["graduation_school"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','id_number')">
					<div class="view">
						<div class="diy_title">
							<span>身份证号</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["id_number"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','awards')">
					<div class="view">
						<div class="diy_title">
							<span>获奖情况</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["awards"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','employment_intention')">
					<div class="view">
						<div class="diy_title">
							<span>就业意向</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["employment_intention"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','social_practice')">
					<div class="view">
						<div class="diy_title">
							<span>社会实践</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["social_practice"] }}
							</span>
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		components: {

		},
		props: {
			obj: {
				type: Object,
				default: function() {
					return {};
				},
			}
		},
		data() {
			return {

			};
		},
		methods: {

		},
	};
</script>

<style>

</style>
