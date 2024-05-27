import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
import register from '../views/register.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},
	// 注册
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {
			index: 0,
			title: '注册'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},
	// 权限路由
	{
		path: '/auth/table',
		name: 'auth_table',
		component: () => import('../views/nav/table.vue'),
		meta: {
			index: 0,
			title: '权限列表'
		}
	},
	{
		path: '/auth/view',
		name: 'auth_view',
		component: () => import('../views/nav/view.vue'),
		meta: {
			index: 0,
			title: '权限详情'
		}
	},

	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
	// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},

	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },
	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},
	// 留言墙路由
	{
		path: '/message_wall/table',
		name: 'message_wall_table',
		component: () => import('../views/message_wall/table.vue')
	},
	{
		path: '/message_wall/view',
		name: 'message_wall_view',
		component: () => import('../views/message_wall/view.vue')
	},
	// 通知公告路由
	{
		path: '/notice_announcement/table',
		name: 'notice_announcement_table',
		component: () => import('../views/notice_announcement/table.vue')
	},
	{
		path: '/notice_announcement/view',
		name: 'notice_announcement_view',
		component: () => import('../views/notice_announcement/view.vue')
	},
	// 合同协议路由
	{
		path: '/contract_agreement/table',
		name: 'contract_agreement_table',
		component: () => import('../views/contract_agreement/table.vue')
	},
	{
		path: '/contract_agreement/view',
		name: 'contract_agreement_view',
		component: () => import('../views/contract_agreement/view.vue')
	},
	// 面试信息路由
	{
		path: '/interview_information/table',
		name: 'interview_information_table',
		component: () => import('../views/interview_information/table.vue')
	},
	{
		path: '/interview_information/view',
		name: 'interview_information_view',
		component: () => import('../views/interview_information/view.vue')
	},
	// 学生路由
	{
		path: '/student/table',
		name: 'student_table',
		component: () => import('../views/student/table.vue')
	},
	{
		path: '/student/view',
		name: 'student_view',
		component: () => import('../views/student/view.vue')
	},
	// 老师路由
	{
		path: '/teacher/table',
		name: 'teacher_table',
		component: () => import('../views/teacher/table.vue')
	},
	{
		path: '/teacher/view',
		name: 'teacher_view',
		component: () => import('../views/teacher/view.vue')
	},
	// 企业用户路由
	{
		path: '/enterprise_users/table',
		name: 'enterprise_users_table',
		component: () => import('../views/enterprise_users/table.vue')
	},
	{
		path: '/enterprise_users/view',
		name: 'enterprise_users_view',
		component: () => import('../views/enterprise_users/view.vue')
	},
	// 企业信息路由
	{
		path: '/enterprise_information/table',
		name: 'enterprise_information_table',
		component: () => import('../views/enterprise_information/table.vue')
	},
	{
		path: '/enterprise_information/view',
		name: 'enterprise_information_view',
		component: () => import('../views/enterprise_information/view.vue')
	},
	// 招聘信息路由
	{
		path: '/recruitment_information/table',
		name: 'recruitment_information_table',
		component: () => import('../views/recruitment_information/table.vue')
	},
	{
		path: '/recruitment_information/view',
		name: 'recruitment_information_view',
		component: () => import('../views/recruitment_information/view.vue')
	},
	// 行业管理路由
	{
		path: '/industry_management/table',
		name: 'industry_management_table',
		component: () => import('../views/industry_management/table.vue')
	},
	{
		path: '/industry_management/view',
		name: 'industry_management_view',
		component: () => import('../views/industry_management/view.vue')
	},
	// 简历信息路由
	{
		path: '/resume_information/table',
		name: 'resume_information_table',
		component: () => import('../views/resume_information/table.vue')
	},
	{
		path: '/resume_information/view',
		name: 'resume_information_view',
		component: () => import('../views/resume_information/view.vue')
	},
	// 学生工作省份路由
	{
		path: '/student_work_province/table',
		name: 'student_work_province_table',
		component: () => import('../views/student_work_province/table.vue')
	},
	{
		path: '/student_work_province/view',
		name: 'student_work_province_view',
		component: () => import('../views/student_work_province/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息管理'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.afterEach((to, from, next) => {
	let title = "学生就业管理系统-admin";
	document.title = title;
})

export default router
