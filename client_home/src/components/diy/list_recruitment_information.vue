<template>
	<div class="diy_home diy_list diy_recruitment_information" id="diy_recruitment_information_list">
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods" v-for="(o, i) in list" :key="i"
				:to="'/recruitment_information/details?recruitment_information_id=' + o['recruitment_information_id']">
				<div class="diy_row" v-if="$check_field('get','enterprise_name','/recruitment_information/details') &&1">
					<div class="diy_title">
						<span>企业名称
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["enterprise_name"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','business_address','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>企业地址
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["business_address"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','enterprise_industry','/recruitment_information/details') &&1">
					<div class="diy_title">
						<span>企业行业
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["enterprise_industry"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','enterprise_picture','/recruitment_information/details') &&1">
					<div class="diy_title">
						<span>企业图片
						</span>
					</div>
					<div class="diy_field diy_img">
						<img :src="$fullUrl(o['enterprise_picture'])" style="width:100%;height:100%" />
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','company_profile','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>企业简介
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["company_profile"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','professional_requirements','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>专业要求
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["professional_requirements"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','age_requirements','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>年龄要求
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["age_requirements"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','character','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>性格
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["character"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','educational_requirements','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>学历要求
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["educational_requirements"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','graduation_school_requirements','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>毕业学校要求
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["graduation_school_requirements"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','recruitment_occupation','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>招聘职业
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["recruitment_occupation"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','certificate_requirements','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>证书要求
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["certificate_requirements"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','occupational_category','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>职业类别
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["occupational_category"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','type_of_work','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>工作类型
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["type_of_work"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','working_province','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>工作省份
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["working_province"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','working_years','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>工作年限
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["working_years"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','a_monthly_salary','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>月薪
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["a_monthly_salary"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','is_it_wrapped','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>是否包住
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["is_it_wrapped"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','working_hours','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>工作时间
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["working_hours"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','compensation_and_benefits','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>薪酬福利
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["compensation_and_benefits"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','job_description','/recruitment_information/details') &&0">
					<div class="diy_title">
						<span>职业描述
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["job_description"] }}
						</span>
					</div>
				</div>
			</router-link>
		</div>
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
					<th class="diy_title" v-if="$check_field('get','enterprise_name')">企业名称
					</th>
					<th class="diy_title" v-if="$check_field('get','business_address')">企业地址
					</th>
					<th class="diy_title" v-if="$check_field('get','enterprise_industry')">企业行业
					</th>
					<th class="diy_title" v-if="$check_field('get','enterprise_picture')">企业图片
					</th>
					<th class="diy_title" v-if="$check_field('get','company_profile')">企业简介
					</th>
					<th class="diy_title" v-if="$check_field('get','professional_requirements')">专业要求
					</th>
					<th class="diy_title" v-if="$check_field('get','age_requirements')">年龄要求
					</th>
					<th class="diy_title" v-if="$check_field('get','character')">性格
					</th>
					<th class="diy_title" v-if="$check_field('get','educational_requirements')">学历要求
					</th>
					<th class="diy_title" v-if="$check_field('get','graduation_school_requirements')">毕业学校要求
					</th>
					<th class="diy_title" v-if="$check_field('get','recruitment_occupation')">招聘职业
					</th>
					<th class="diy_title" v-if="$check_field('get','certificate_requirements')">证书要求
					</th>
					<th class="diy_title" v-if="$check_field('get','occupational_category')">职业类别
					</th>
					<th class="diy_title" v-if="$check_field('get','type_of_work')">工作类型
					</th>
					<th class="diy_title" v-if="$check_field('get','working_province')">工作省份
					</th>
					<th class="diy_title" v-if="$check_field('get','working_years')">工作年限
					</th>
					<th class="diy_title" v-if="$check_field('get','a_monthly_salary')">月薪
					</th>
					<th class="diy_title" v-if="$check_field('get','is_it_wrapped')">是否包住
					</th>
					<th class="diy_title" v-if="$check_field('get','working_hours')">工作时间
					</th>
					<th class="diy_title" v-if="$check_field('get','compensation_and_benefits')">薪酬福利
					</th>
					<th class="diy_title" v-if="$check_field('get','job_description')">职业描述
					</th>
				</tr>
				<tr class="diy_row" v-for="(o,i) in list">
					<td class="diy_field diy_text" v-if="$check_field('get','enterprise_name')">
						<span>
							{{ o["enterprise_name"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','business_address')">
						<span>
							{{ o["business_address"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','enterprise_industry')">
						<span>
							{{ o["enterprise_industry"] }}
						</span>
					</td>
					<td class="diy_field" v-if="$check_field('get','enterprise_picture')">
						<img class="diy_img" :src="o['enterprise_picture']" />
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','company_profile')">
						<span>
							{{ o["company_profile"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','professional_requirements')">
						<span>
							{{ o["professional_requirements"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','age_requirements')">
						<span>
							{{ o["age_requirements"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','character')">
						<span>
							{{ o["character"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','educational_requirements')">
						<span>
							{{ o["educational_requirements"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','graduation_school_requirements')">
						<span>
							{{ o["graduation_school_requirements"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','recruitment_occupation')">
						<span>
							{{ o["recruitment_occupation"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','certificate_requirements')">
						<span>
							{{ o["certificate_requirements"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','occupational_category')">
						<span>
							{{ o["occupational_category"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','type_of_work')">
						<span>
							{{ o["type_of_work"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','working_province')">
						<span>
							{{ o["working_province"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','working_years')">
						<span>
							{{ o["working_years"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','a_monthly_salary')">
						<span>
							{{ o["a_monthly_salary"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','is_it_wrapped')">
						<span>
							{{ o["is_it_wrapped"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','working_hours')">
						<span>
							{{ o["working_hours"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','compensation_and_benefits')">
						<span>
							{{ o["compensation_and_benefits"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','job_description')">
						<span>
							{{ o["job_description"] }}
						</span>
					</td>
				</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {};
		},
  };
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

