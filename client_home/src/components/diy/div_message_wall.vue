<template>
	<div class="diy_details diy_div_message_wall">
		<div class="warp">
			<div class="container">
				<div class="row">
				<div class="col-12 col-md-6" v-if="$check_field('get','message_title')">
					<div class="view">
						<div class="diy_title">
							<span>留言标题</span>
						</div>
						<div class="diy_field diy_text">
							<span>
								{{ obj["message_title"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','message_time')">
					<div class="view">
						<div class="diy_title">
							<span>留言时间</span>
						</div>
						<div class="diy_field diy_date">
							<span>
								{{ $toTime(obj["message_time"] ,"yyyy-MM-dd") }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','message_content')">
					<div class="view">
						<div class="diy_title">
							<span>留言内容</span>
						</div>
						<div class="diy_field diy_desc">
							<span>
								{{ obj["message_content"] }}
							</span>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6" v-if="$check_field('get','cover')">
					<div class="view">
						<div class="diy_title">
							<span>封面</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(obj['cover'])" />
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
