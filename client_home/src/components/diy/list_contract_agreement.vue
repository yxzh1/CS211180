<template>
	<div class="diy_home diy_list diy_contract_agreement" id="diy_contract_agreement_list">
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods" v-for="(o, i) in list" :key="i"
				:to="'/contract_agreement/details?contract_agreement_id=' + o['contract_agreement_id']">
				<div class="diy_row" v-if="$check_field('get','enterprise_name','/contract_agreement/details') &&0">
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
				<div class="diy_row" v-if="$check_field('get','enterprise_industry','/contract_agreement/details') &&0">
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
			</router-link>
		</div>
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
					<th class="diy_title" v-if="$check_field('get','enterprise_name')">企业名称
					</th>
					<th class="diy_title" v-if="$check_field('get','enterprise_industry')">企业行业
					</th>
				</tr>
				<tr class="diy_row" v-for="(o,i) in list">
					<td class="diy_field diy_text" v-if="$check_field('get','enterprise_name')">
						<span>
							{{ o["enterprise_name"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','enterprise_industry')">
						<span>
							{{ o["enterprise_industry"] }}
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

