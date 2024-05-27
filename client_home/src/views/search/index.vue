<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
							<!-- 商品搜索结果 -->
			  <list_result_search
				:list="result_goods"
				title="商品"
				source_table="goods"
			  ></list_result_search>

							<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="文章"
				source_table="article"
			  ></list_result_search>

							<!-- 论坛搜索结果 -->
			  <list_result_search
				:list="result_forum"
				title="论坛"
				source_table="forum"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/message_wall/list', 'get')"
				:list="result_message_title"
				title="留言标题"
				source_table="message_title"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/message_wall/list', 'get')"
				:list="result_message_person"
				title="留言人"
				source_table="message_person"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/notice_announcement/list', 'get')"
				:list="result_announcement_title"
				title="公告标题"
				source_table="announcement_title"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/notice_announcement/list', 'get')"
				:list="result_release_time"
				title="发布时间"
				source_table="release_time"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/contract_agreement/list', 'get')"
				:list="result_enterprise_name"
				title="企业名称"
				source_table="enterprise_name"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/contract_agreement/list', 'get')"
				:list="result_student"
				title="学生"
				source_table="student"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/interview_information/list', 'get')"
				:list="result_student"
				title="学生"
				source_table="student"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/interview_information/list', 'get')"
				:list="result_enterprise_name"
				title="企业名称"
				source_table="enterprise_name"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/student/list', 'get')"
				:list="result_gender"
				title="性别"
				source_table="gender"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/student/list', 'get')"
				:list="result_full_name"
				title="姓名"
				source_table="full_name"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/student/list', 'get')"
				:list="result_major"
				title="专业"
				source_table="major"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/teacher/list', 'get')"
				:list="result_gender"
				title="性别"
				source_table="gender"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/enterprise_users/list', 'get')"
				:list="result_gender"
				title="性别"
				source_table="gender"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/enterprise_information/list', 'get')"
				:list="result_enterprise_name"
				title="企业名称"
				source_table="enterprise_name"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/enterprise_information/list', 'get')"
				:list="result_person_in_charge"
				title="负责人"
				source_table="person_in_charge"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/recruitment_information/list', 'get')"
				:list="result_enterprise_name"
				title="企业名称"
				source_table="enterprise_name"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/recruitment_information/list', 'get')"
				:list="result_enterprise_industry"
				title="企业行业"
				source_table="enterprise_industry"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/recruitment_information/list', 'get')"
				:list="result_type_of_work"
				title="工作类型"
				source_table="type_of_work"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/recruitment_information/list', 'get')"
				:list="result_working_province"
				title="工作省份"
				source_table="working_province"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/recruitment_information/list', 'get')"
				:list="result_is_it_wrapped"
				title="是否包住"
				source_table="is_it_wrapped"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/industry_management/list', 'get')"
				:list="result_industry_name"
				title="行业名称"
				source_table="industry_name"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/resume_information/list', 'get')"
				:list="result_enterprise_name"
				title="企业名称"
				source_table="enterprise_name"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/resume_information/list', 'get')"
				:list="result_student"
				title="学生"
				source_table="student"
			  ></list_result_search>
			  <list_result_search
								v-if="$check_action('/student_work_province/list', 'get')"
				:list="result_province_name"
				title="省份名称"
				source_table="province_name"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_goods": [],
	  "result_article": [],
	  "result_forum": [],
			"result_message_title":[],
			"result_message_person":[],
			"result_announcement_title":[],
			"result_release_time":[],
			"result_enterprise_name":[],
			"result_student":[],
			"result_student":[],
			"result_enterprise_name":[],
			"result_gender":[],
			"result_full_name":[],
			"result_major":[],
			"result_gender":[],
			"result_gender":[],
			"result_enterprise_name":[],
			"result_person_in_charge":[],
			"result_enterprise_name":[],
			"result_enterprise_industry":[],
			"result_type_of_work":[],
			"result_working_province":[],
			"result_is_it_wrapped":[],
			"result_industry_name":[],
			"result_enterprise_name":[],
			"result_student":[],
			"result_province_name":[],
	};
  },
  methods: {
	/**
	 * 获取商品
	 */
	get_goods() {
	  this.$get("~/api/goods/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_goods = json.result.list;
		}
	  });
	},
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取论坛
	 */
	get_forum() {
	  this.$get("~/api/forum/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_forum = json.result.list;
		}
	  });
	},
	/**
	 * 获取message_title
	 */
	get_message_title(){
		this.$get("~/api/message_wall/get_list?like=0", { page: 1, size: 10, "message_title": this.query.word }, (json) => {
		  if (json.result) {
	  var result_message_title = json.result.list;
				result_message_title.map(o => o.title = o['message_title'])
	  this.result_message_title = result_message_title
		  }
		});
	},
	/**
	 * 获取message_person
	 */
	get_message_person(){
		this.$get("~/api/message_wall/get_list?like=0", { page: 1, size: 10, "message_person": this.query.word }, (json) => {
		  if (json.result) {
	  var result_message_person = json.result.list;
				result_message_person.map(o => o.title = o['message_person'])
	  this.result_message_person = result_message_person
		  }
		});
	},
	/**
	 * 获取announcement_title
	 */
	get_announcement_title(){
		this.$get("~/api/notice_announcement/get_list?like=0", { page: 1, size: 10, "announcement_title": this.query.word }, (json) => {
		  if (json.result) {
	  var result_announcement_title = json.result.list;
				result_announcement_title.map(o => o.title = o['announcement_title'])
	  this.result_announcement_title = result_announcement_title
		  }
		});
	},
	/**
	 * 获取release_time
	 */
	get_release_time(){
		this.$get("~/api/notice_announcement/get_list?like=0", { page: 1, size: 10, "release_time": this.query.word }, (json) => {
		  if (json.result) {
	  var result_release_time = json.result.list;
				result_release_time.map(o => o.title = o['release_time'])
	  this.result_release_time = result_release_time
		  }
		});
	},
	/**
	 * 获取enterprise_name
	 */
	get_enterprise_name(){
		this.$get("~/api/contract_agreement/get_list?like=0", { page: 1, size: 10, "enterprise_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_enterprise_name = json.result.list;
				result_enterprise_name.map(o => o.title = o['enterprise_name'])
	  this.result_enterprise_name = result_enterprise_name
		  }
		});
	},
	/**
	 * 获取student
	 */
	get_student(){
		this.$get("~/api/contract_agreement/get_list?like=0", { page: 1, size: 10, "student": this.query.word }, (json) => {
		  if (json.result) {
	  var result_student = json.result.list;
				result_student.map(o => o.title = o['student'])
	  this.result_student = result_student
		  }
		});
	},
	/**
	 * 获取student
	 */
	get_student(){
		this.$get("~/api/interview_information/get_list?like=0", { page: 1, size: 10, "student": this.query.word }, (json) => {
		  if (json.result) {
	  var result_student = json.result.list;
				result_student.map(o => o.title = o['student'])
	  this.result_student = result_student
		  }
		});
	},
	/**
	 * 获取enterprise_name
	 */
	get_enterprise_name(){
		this.$get("~/api/interview_information/get_list?like=0", { page: 1, size: 10, "enterprise_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_enterprise_name = json.result.list;
				result_enterprise_name.map(o => o.title = o['enterprise_name'])
	  this.result_enterprise_name = result_enterprise_name
		  }
		});
	},
	/**
	 * 获取gender
	 */
	get_gender(){
		this.$get("~/api/student/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
	  var result_gender = json.result.list;
				result_gender.map(o => o.title = o['gender'])
	  this.result_gender = result_gender
		  }
		});
	},
	/**
	 * 获取full_name
	 */
	get_full_name(){
		this.$get("~/api/student/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_full_name = json.result.list;
				result_full_name.map(o => o.title = o['full_name'])
	  this.result_full_name = result_full_name
		  }
		});
	},
	/**
	 * 获取major
	 */
	get_major(){
		this.$get("~/api/student/get_list?like=0", { page: 1, size: 10, "major": this.query.word }, (json) => {
		  if (json.result) {
	  var result_major = json.result.list;
				result_major.map(o => o.title = o['major'])
	  this.result_major = result_major
		  }
		});
	},
	/**
	 * 获取gender
	 */
	get_gender(){
		this.$get("~/api/teacher/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
	  var result_gender = json.result.list;
				result_gender.map(o => o.title = o['gender'])
	  this.result_gender = result_gender
		  }
		});
	},
	/**
	 * 获取gender
	 */
	get_gender(){
		this.$get("~/api/enterprise_users/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
	  var result_gender = json.result.list;
				result_gender.map(o => o.title = o['gender'])
	  this.result_gender = result_gender
		  }
		});
	},
	/**
	 * 获取enterprise_name
	 */
	get_enterprise_name(){
		this.$get("~/api/enterprise_information/get_list?like=0", { page: 1, size: 10, "enterprise_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_enterprise_name = json.result.list;
				result_enterprise_name.map(o => o.title = o['enterprise_name'])
	  this.result_enterprise_name = result_enterprise_name
		  }
		});
	},
	/**
	 * 获取person_in_charge
	 */
	get_person_in_charge(){
		this.$get("~/api/enterprise_information/get_list?like=0", { page: 1, size: 10, "person_in_charge": this.query.word }, (json) => {
		  if (json.result) {
	  var result_person_in_charge = json.result.list;
				result_person_in_charge.map(o => o.title = o['person_in_charge'])
	  this.result_person_in_charge = result_person_in_charge
		  }
		});
	},
	/**
	 * 获取enterprise_name
	 */
	get_enterprise_name(){
		this.$get("~/api/recruitment_information/get_list?like=0", { page: 1, size: 10, "enterprise_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_enterprise_name = json.result.list;
				result_enterprise_name.map(o => o.title = o['enterprise_name'])
	  this.result_enterprise_name = result_enterprise_name
		  }
		});
	},
	/**
	 * 获取enterprise_industry
	 */
	get_enterprise_industry(){
		this.$get("~/api/recruitment_information/get_list?like=0", { page: 1, size: 10, "enterprise_industry": this.query.word }, (json) => {
		  if (json.result) {
	  var result_enterprise_industry = json.result.list;
				result_enterprise_industry.map(o => o.title = o['enterprise_industry'])
	  this.result_enterprise_industry = result_enterprise_industry
		  }
		});
	},
	/**
	 * 获取type_of_work
	 */
	get_type_of_work(){
		this.$get("~/api/recruitment_information/get_list?like=0", { page: 1, size: 10, "type_of_work": this.query.word }, (json) => {
		  if (json.result) {
	  var result_type_of_work = json.result.list;
				result_type_of_work.map(o => o.title = o['type_of_work'])
	  this.result_type_of_work = result_type_of_work
		  }
		});
	},
	/**
	 * 获取working_province
	 */
	get_working_province(){
		this.$get("~/api/recruitment_information/get_list?like=0", { page: 1, size: 10, "working_province": this.query.word }, (json) => {
		  if (json.result) {
	  var result_working_province = json.result.list;
				result_working_province.map(o => o.title = o['working_province'])
	  this.result_working_province = result_working_province
		  }
		});
	},
	/**
	 * 获取is_it_wrapped
	 */
	get_is_it_wrapped(){
		this.$get("~/api/recruitment_information/get_list?like=0", { page: 1, size: 10, "is_it_wrapped": this.query.word }, (json) => {
		  if (json.result) {
	  var result_is_it_wrapped = json.result.list;
				result_is_it_wrapped.map(o => o.title = o['is_it_wrapped'])
	  this.result_is_it_wrapped = result_is_it_wrapped
		  }
		});
	},
	/**
	 * 获取industry_name
	 */
	get_industry_name(){
		this.$get("~/api/industry_management/get_list?like=0", { page: 1, size: 10, "industry_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_industry_name = json.result.list;
				result_industry_name.map(o => o.title = o['industry_name'])
	  this.result_industry_name = result_industry_name
		  }
		});
	},
	/**
	 * 获取enterprise_name
	 */
	get_enterprise_name(){
		this.$get("~/api/resume_information/get_list?like=0", { page: 1, size: 10, "enterprise_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_enterprise_name = json.result.list;
				result_enterprise_name.map(o => o.title = o['enterprise_name'])
	  this.result_enterprise_name = result_enterprise_name
		  }
		});
	},
	/**
	 * 获取student
	 */
	get_student(){
		this.$get("~/api/resume_information/get_list?like=0", { page: 1, size: 10, "student": this.query.word }, (json) => {
		  if (json.result) {
	  var result_student = json.result.list;
				result_student.map(o => o.title = o['student'])
	  this.result_student = result_student
		  }
		});
	},
	/**
	 * 获取province_name
	 */
	get_province_name(){
		this.$get("~/api/student_work_province/get_list?like=0", { page: 1, size: 10, "province_name": this.query.word }, (json) => {
		  if (json.result) {
	  var result_province_name = json.result.list;
				result_province_name.map(o => o.title = o['province_name'])
	  this.result_province_name = result_province_name
		  }
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_goods();
	this.get_article();
	this.get_forum();
		this.get_message_title();
		this.get_message_person();
		this.get_announcement_title();
		this.get_release_time();
		this.get_enterprise_name();
		this.get_student();
		this.get_student();
		this.get_enterprise_name();
		this.get_gender();
		this.get_full_name();
		this.get_major();
		this.get_gender();
		this.get_gender();
		this.get_enterprise_name();
		this.get_person_in_charge();
		this.get_enterprise_name();
		this.get_enterprise_industry();
		this.get_type_of_work();
		this.get_working_province();
		this.get_is_it_wrapped();
		this.get_industry_name();
		this.get_enterprise_name();
		this.get_student();
		this.get_province_name();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_goods();
	  this.get_article();
	  this.get_forum();
	  this.get_message_title();
	  this.get_message_person();
	  this.get_announcement_title();
	  this.get_release_time();
	  this.get_enterprise_name();
	  this.get_student();
	  this.get_student();
	  this.get_enterprise_name();
	  this.get_gender();
	  this.get_full_name();
	  this.get_major();
	  this.get_gender();
	  this.get_gender();
	  this.get_enterprise_name();
	  this.get_person_in_charge();
	  this.get_enterprise_name();
	  this.get_enterprise_industry();
	  this.get_type_of_work();
	  this.get_working_province();
	  this.get_is_it_wrapped();
	  this.get_industry_name();
	  this.get_enterprise_name();
	  this.get_student();
	  this.get_province_name();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
