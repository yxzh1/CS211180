<template>
	<div class="diy_home diy_list diy_student_work_province" id="diy_student_work_province_list">
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods" v-for="(o, i) in list" :key="i"
				:to="'/student_work_province/details?student_work_province_id=' + o['student_work_province_id']">
				<div class="diy_row" v-if="$check_field('get','province_name','/student_work_province/details') &&0">
					<div class="diy_title">
						<span>省份名称
						</span>
					</div>
					<div class="diy_field diy_text">
						<span>
							{{ o["province_name"] }}
						</span>
					</div>
				</div>
				<div class="diy_row" v-if="$check_field('get','number_of_students','/student_work_province/details') &&0">
					<div class="diy_title">
						<span>学生数量
						</span>
					</div>
					<div class="diy_field diy_number">
						<span>
							{{ o['number_of_students'] }}
						</span>
					</div>
				</div>
			</router-link>
		</div>
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
					<th class="diy_title" v-if="$check_field('get','province_name')">省份名称
					</th>
					<th class="diy_title" v-if="$check_field('get','number_of_students')">学生数量
					</th>
				</tr>
				<tr class="diy_row" v-for="(o,i) in list">
					<td class="diy_field diy_text" v-if="$check_field('get','province_name')">
						<span>
							{{ o["province_name"] }}
						</span>
					</td>
					<td class="diy_field diy_number" v-if="$check_field('get','number_of_students')">
						<span>
							{{ o["number_of_students"] }}
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

