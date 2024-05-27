<template>
	<div class="diy_details diy_div_interview_information">
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
				<div class="col-12 col-md-6" v-if="$check_field('get','invitation_information')">
					<div class="view">
						<div class="diy_title">
							<span>邀请信息</span>
						</div>
						<div class="diy_field diy_desc">
							<span>
								{{ obj["invitation_information"] }}
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
