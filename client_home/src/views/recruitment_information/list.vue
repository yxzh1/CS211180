<template>
	<div class="diy_list page_recruitment_information" id="recruitment_information_list">
		<div class="warp">
			<div class="container">
				<div class="row">
					<div class="col">
						<span class="title">招聘信息列表</span>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">
							<b-form-input size="sm" class="mr-sm-2" placeholder="企业名称搜索" v-model="query['enterprise_name']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="企业行业搜索" v-model="query['enterprise_industry']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="工作类型搜索" v-model="query['type_of_work']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="工作省份搜索" v-model="query['working_province']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="是否包住搜索" v-model="query['is_it_wrapped']" />
							<b-button size="sm" @click="search()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
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
						<list_recruitment_information :list="list" />
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
	import list_recruitment_information from "@/components/diy/list_recruitment_information.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_recruitment_information
		},
		data() {
			return {
				url_get_list: "~/api/recruitment_information/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
					"enterprise_name": "", // 企业名称
					"enterprise_industry": "", // 企业行业
					"type_of_work": "", // 工作类型
					"working_province": "", // 工作省份
					"is_it_wrapped": "", // 是否包住
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
						name: "企业名称正序",
						value: "`enterprise_name` asc",
					},
					{
						name: "企业名称倒序",
						value: "`enterprise_name` desc",
					},
					{
						name: "企业行业正序",
						value: "`enterprise_industry` asc",
					},
					{
						name: "企业行业倒序",
						value: "`enterprise_industry` desc",
					},
					{
						name: "工作类型正序",
						value: "`type_of_work` asc",
					},
					{
						name: "工作类型倒序",
						value: "`type_of_work` desc",
					},
					{
						name: "工作省份正序",
						value: "`working_province` asc",
					},
					{
						name: "工作省份倒序",
						value: "`working_province` desc",
					},
					{
						name: "是否包住正序",
						value: "`is_it_wrapped` asc",
					},
					{
						name: "是否包住倒序",
						value: "`is_it_wrapped` desc",
					},
				],
				// 工作类型列表
				"list_type_of_work": ['全职','兼职'],
				// 是否包住列表
				"list_is_it_wrapped": ['是','否'],
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
			filter_type_of_work(o) {
				if (o == "全部") {
					this.query["type_of_work"] = "";
				} else {
					this.query["type_of_work"] = o;
				}
				this.search();
			},
			filter_is_it_wrapped(o) {
				if (o == "全部") {
					this.query["is_it_wrapped"] = "";
				} else {
					this.query["is_it_wrapped"] = o;
				}
				this.search();
			},

			/**
			 * 重置
			 */
			reset() {
				this.query.enterprise_name = ""
				this.query.enterprise_industry = ""
				this.query.type_of_work = ""
				this.query.working_province = ""
				this.query.is_it_wrapped = ""
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
		}
	}
</script>

<style>
</style>
