<template>
	<div class="diy_details diy_div_notice_announcement">
		<div class="warp">
			<div class="container">
				<div class="row">
				<div class="col-12 col-md-6" v-if="$check_field('get','announcement_title')">
					<div class="view">
						<div class="diy_title">
							<span>公告标题</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["announcement_title"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','announcement_no')">
					<div class="view">
						<div class="diy_title">
							<span>公告编号</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["announcement_no"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','release_time')">
					<div class="view">
						<div class="diy_title">
							<span>发布时间</span>
						</div>
						<div class="diy_field diy_date">
							<span>
								{{ $toTime(obj["release_time"] ,"yyyy-MM-dd") }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','announcement_content')">
					<div class="view">
						<div class="diy_title">
							<span>公告内容</span>
						</div>
						<div class="diy_field diy_html" v-html="obj['announcement_content']" >

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
