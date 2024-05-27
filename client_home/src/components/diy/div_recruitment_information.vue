<template>
	<div class="diy_details diy_div_recruitment_information">
		<div class="warp">
			<div class="container">
				<div class="row">
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','enterprise_name')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>企业名称</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["enterprise_name"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','business_address')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>企业地址</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["business_address"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','enterprise_industry')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>企业行业</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["enterprise_industry"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','enterprise_picture')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>企业图片</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(obj['enterprise_picture'])" />
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','company_profile')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>企业简介</span>
						</div>
						<div class="diy_field diy_desc">
							<span>
								{{ obj["company_profile"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','professional_requirements')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>专业要求</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["professional_requirements"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','age_requirements')">
					<div class="view">
						<div class="diy_title">
							<span>年龄要求</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["age_requirements"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','character')">
					<div class="view">
						<div class="diy_title">
							<span>性格</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["character"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','educational_requirements')">-->
				<div class="col-12 col-md-6">
					<div class="view">
						<div class="diy_title">
							<span>学历要求</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["educational_requirements"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','graduation_school_requirements')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>毕业学校要求</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["graduation_school_requirements"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','recruitment_occupation')">
<!--				<div class="col-12 col-md-6" >-->
					<div class="view">
						<div class="diy_title">
							<span>招聘职业</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["recruitment_occupation"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','certificate_requirements')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>证书要求</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["certificate_requirements"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','occupational_category')">
					<div class="view">
						<div class="diy_title">
							<span>职业类别</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["occupational_category"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','type_of_work')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>工作类型</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["type_of_work"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','working_province')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>工作省份</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["working_province"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','working_years')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>工作年限</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["working_years"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','a_monthly_salary')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>月薪</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["a_monthly_salary"] }}
							</span>
						</div>
					</div>
				</div>
<!--				<div class="col-12 col-md-6" v-if="$check_field('get','is_it_wrapped')">-->
				<div class="col-12 col-md-6" >
					<div class="view">
						<div class="diy_title">
							<span>是否包住</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["is_it_wrapped"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','working_hours')">
					<div class="view">
						<div class="diy_title">
							<span>工作时间</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["working_hours"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','compensation_and_benefits')">
					<div class="view">
						<div class="diy_title">
							<span>薪酬福利</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["compensation_and_benefits"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','job_description')">
					<div class="view">
						<div class="diy_title">
							<span>职业描述</span>
						</div>
						<div class="diy_field diy_desc">
							<span>
								{{ obj["job_description"] }}
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
