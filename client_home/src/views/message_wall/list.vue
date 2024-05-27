<template>
	<div class="diy_list page_message_wall" id="message_wall_list">
		<div class="warp">
			<div class="container">
				<div class="row">
					<div class="col">
						<span class="title">留言墙列表</span>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">
							<b-form-input size="sm" class="mr-sm-2" placeholder="留言标题搜索" v-model="query['message_title']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="留言人搜索" v-model="query['message_person']" />
							<b-button size="sm" @click="search()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
					</div>
				</div>
				<div class="row">
					<div class="col">
						<!-- 筛选 -->
						<div class="view">
							<b-dropdown text="留言人" variant="outline-dark" left>
								<b-dropdown-item @click="filter_set('全部','message_person')">全部</b-dropdown-item>
								<b-dropdown-item v-for="o in list_message_person" :key="o['user_id']" @click="filter_set(o['user_id'],'message_person')">
									{{ o['nickname'] + '-' + o['username'] }}
								</b-dropdown-item>
							</b-dropdown>
						</div>
						<!-- /筛选 -->
					</div>
				</div>
				<div class="row">
					<div class="col">
						<!-- 排序 -->
						<div class="view">
							<b-dropdown text="排序" variant="outline-dark" left>
							    <b-dropdown-item v-for="(o, i) in list_sort" :key="i" @click="set_sort(o)" >
							        {{ o.name }}
							    </b-dropdown-item>
							</b-dropdown>
						</div>
						<!--/排序 -->
					</div>
				</div>
				<div class="row">
					<div class="col">
						<!-- 列表 -->
						<list_message_wall :list="list" />
						<!-- /列表 -->
					</div>
				</div>
				<div class="row">
					<div class="col overflow-auto flex_cc">
						<!-- 分页器 -->
						<diy_pager v-model="query['page']" :size="query['size']" :count="count" v-on:toPage="toPage" v-on:toSize="toSize" ></diy_pager>
						<!-- /分页器 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import list_message_wall from "@/components/diy/list_message_wall.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_message_wall
		},
		data() {
			return {
				url_get_list: "~/api/message_wall/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
					"message_title": "", // 留言标题
					"message_person": 0, // 留言人
				},

				// 排序内容
				list_sort: [{
						name: "创建时间从高到低",
						value: "`create_time` desc",
					},
					{
						name: "创建时间从低到高",
						value: "`create_time` asc",
					},
					{
						name: "更新时间从高到低",
						value: "`update_time` desc",
					},
					{
						name: "更新时间从低到高",
						value: "`update_time` asc",
					},
					{
						name: "留言标题正序",
						value: "`message_title` asc",
					},
					{
						name: "留言标题倒序",
						value: "`message_title` desc",
					},
					{
						name: "留言人正序",
						value: "`message_person` asc",
					},
					{
						name: "留言人倒序",
						value: "`message_person` desc",
					},
				],
				list_message_person: [],
			}
		},
		methods: {
			/**
			 * 筛选选择
			 */
			filter_set(o,key) {
			    if (o == "全部") {
			        this.query[key] = "";
			    } else {
			        this.query[key] = o;
			    }
			    this.search();
			},

			/**
			 * 排序
			 */
			set_sort(o) {
			    this.query.orderby = o.value;
			    this.search();
			},

			/**
			 * 筛选
			 */
			/**
			 * 获取留言人列表
			 */
			async get_list_message_person() {
				var json = await this.$get("~/api/user/get_list?user_group=学生");
				if(json.result && json.result.list){
					this.list_message_person = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			/**
			 * 重置
			 */
			reset() {
				this.query.message_title = ""
				this.query.message_person = ""
				this.search();
			},

			// 返回条数
			toSize(i){
				this.query.size = i;
				this.first();
			},

			// 返回页数
			toPage(i){
				this.query.page = i;
				this.first();
			},
		},
		computed: {
		},
		created() {
			this.get_list_message_person();
		}
	}
</script>

<style>
</style>
