<template>
	<div class="diy_home diy_list diy_student" id="diy_student_list">
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods" v-for="(o, i) in list" :key="i"
				:to="'/student/details?student_id=' + o['student_id']">
				<div class="diy_row" v-if="$check_field('get','gender','/student/details') &&0">
					<div class="diy_title">
						<span>性别
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["gender"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','personal_profile','/student/details') &&0">
					<div class="diy_title">
						<span>个人简介
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["personal_profile"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','full_name','/student/details') &&0">
					<div class="diy_title">
						<span>姓名
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["full_name"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','certificate','/student/details') &&0">
					<div class="diy_title">
						<span>证书
						</span>
					</div>
					<div class="diy_field diy_img">
						<img :src="$fullUrl(o['certificate'])" style="width:100%;height:100%" />
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','age','/student/details') &&0">
					<div class="diy_title">
						<span>年龄
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["age"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','major','/student/details') &&0">
					<div class="diy_title">
						<span>专业
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["major"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','registered_residence','/student/details') &&0">
					<div class="diy_title">
						<span>户籍地
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["registered_residence"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','nation','/student/details') &&0">
					<div class="diy_title">
						<span>民族
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["nation"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','education','/student/details') &&0">
					<div class="diy_title">
						<span>学历
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["education"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','graduation_school','/student/details') &&0">
					<div class="diy_title">
						<span>毕业学校
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["graduation_school"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','id_number','/student/details') &&0">
					<div class="diy_title">
						<span>身份证号
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["id_number"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','awards','/student/details') &&0">
					<div class="diy_title">
						<span>获奖情况
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["awards"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','employment_intention','/student/details') &&0">
					<div class="diy_title">
						<span>就业意向
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["employment_intention"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','social_practice','/student/details') &&0">
					<div class="diy_title">
						<span>社会实践
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["social_practice"] }}
						</span>
					</div>
				</div>
			</router-link>
		</div>
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
					<th class="diy_title" v-if="$check_field('get','gender')">性别
					</th>
					<th class="diy_title" v-if="$check_field('get','personal_profile')">个人简介
					</th>
					<th class="diy_title" v-if="$check_field('get','full_name')">姓名
					</th>
					<th class="diy_title" v-if="$check_field('get','certificate')">证书
					</th>
					<th class="diy_title" v-if="$check_field('get','age')">年龄
					</th>
					<th class="diy_title" v-if="$check_field('get','major')">专业
					</th>
					<th class="diy_title" v-if="$check_field('get','registered_residence')">户籍地
					</th>
					<th class="diy_title" v-if="$check_field('get','nation')">民族
					</th>
					<th class="diy_title" v-if="$check_field('get','education')">学历
					</th>
					<th class="diy_title" v-if="$check_field('get','graduation_school')">毕业学校
					</th>
					<th class="diy_title" v-if="$check_field('get','id_number')">身份证号
					</th>
					<th class="diy_title" v-if="$check_field('get','awards')">获奖情况
					</th>
					<th class="diy_title" v-if="$check_field('get','employment_intention')">就业意向
					</th>
					<th class="diy_title" v-if="$check_field('get','social_practice')">社会实践
					</th>
				</tr>
				<tr class="diy_row" v-for="(o,i) in list">
					<td class="diy_field diy_text" v-if="$check_field('get','gender')">
						<span>
							{{ o["gender"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','personal_profile')">
						<span>
							{{ o["personal_profile"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','full_name')">
						<span>
							{{ o["full_name"] }}
						</span>
					</td>
					<td class="diy_field" v-if="$check_field('get','certificate')">
						<img class="diy_img" :src="o['certificate']" />
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','age')">
						<span>
							{{ o["age"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','major')">
						<span>
							{{ o["major"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','registered_residence')">
						<span>
							{{ o["registered_residence"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','nation')">
						<span>
							{{ o["nation"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','education')">
						<span>
							{{ o["education"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','graduation_school')">
						<span>
							{{ o["graduation_school"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','id_number')">
						<span>
							{{ o["id_number"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','awards')">
						<span>
							{{ o["awards"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','employment_intention')">
						<span>
							{{ o["employment_intention"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','social_practice')">
						<span>
							{{ o["social_practice"] }}
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

