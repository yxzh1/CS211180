<template>
	<div class="diy_details diy_div_student_work_province">
		<div class="warp">
			<div class="container">
				<div class="row">
				<div class="col-12 col-md-6" v-if="$check_field('get','province_name')">
					<div class="view">
						<div class="diy_title">
							<span>省份名称</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["province_name"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','number_of_students')">
					<div class="view">
						<div class="diy_title">
							<span>学生数量</span>
						</div>
						<div class="diy_field diy_number">
							<span>
								{{ obj["number_of_students"] }}
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
