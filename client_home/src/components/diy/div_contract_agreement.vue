<template>
	<div class="diy_details diy_div_contract_agreement">
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
				<div class="col-12 col-md-6" v-if="$check_field('get','contract_agreement')">
					<div class="view">
						<div class="diy_title">
							<span>合同协议</span>
						</div>
						<div class="diy_field diy_music">
							<a :href="$fullUrl(obj['contract_agreement'])" target="_blank" style="color: rgb(64, 158, 255);">点击下载</a>
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
