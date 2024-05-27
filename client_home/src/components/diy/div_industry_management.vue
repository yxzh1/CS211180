<template>
	<div class="diy_details diy_div_industry_management">
		<div class="warp">
			<div class="container">
				<div class="row">
				<div class="col-12 col-md-6" v-if="$check_field('get','industry_name')">
					<div class="view">
						<div class="diy_title">
							<span>行业名称</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["industry_name"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','industry_number')">
					<div class="view">
						<div class="diy_title">
							<span>行业编号</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["industry_number"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','industry_details')">
					<div class="view">
						<div class="diy_title">
							<span>行业详情</span>
						</div>
						<div class="diy_field diy_desc">
							<span>
								{{ obj["industry_details"] }}
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
