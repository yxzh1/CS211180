<template>
	<div class="diy_details diy_div_enterprise_information">
		<div class="warp">
			<div class="container">
				<div class="row">
				<div class="col-12 col-md-6" v-if="$check_field('get','enterprise_name')">
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
				<div class="col-12 col-md-6" v-if="$check_field('get','business_address')">
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
				<div class="col-12 col-md-6" v-if="$check_field('get','enterprise_industry')">
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
				<div class="col-12 col-md-6" v-if="$check_field('get','company_profile')">
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
				<div class="col-12 col-md-6" v-if="$check_field('get','enterprise_picture')">
					<div class="view">
						<div class="diy_title">
							<span>企业图片</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(obj['enterprise_picture'])" />
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
