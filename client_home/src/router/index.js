import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue'
import login from '../views/account/login.vue';

Vue.use(VueRouter)

const routes = [
	// 主页ss
	{
		path: '/',
		name: 'index',
		component: index
	},
	// 登录
	{
		path: '/account/login',
		name: 'login',
		component: login
	},
	// 忘记密码
	{
		path: '/account/forgot',
		name: 'forgot',
		component: () => import('../views/account/forgot.vue')
	},
	// 注册账号
	{
		path: '/account/register',
		name: 'register',
		component: () => import('../views/account/register.vue')
	},
	// 媒体图片
	{
		path: '/media/image',
		name: 'media_image',
		component: () => import('../views/media/image.vue')
	},
	// 音乐
	{
		path: '/media/music',
		name: 'media_music',
		component: () => import('../views/media/music.vue')
	},
	// 媒体视频
	{
		path: '/media/video',
		name: 'media_video',
		component: () => import('../views/media/video.vue')
	},
	// 文章路由
	{
		path: '/article/list',
		name: 'article_list',
		component: () => import('../views/article/list.vue')
	},
	{
		path: '/article/details',
		name: 'article_details',
		component: () => import('../views/article/details.vue')
	},
	// 浏览网站
	// 收藏路由
	{
		path: '/user/collect',
		name: 'collect_list',
		component: () => import('../views/user/collect.vue')
	},
	//留言墙添加路由
	{
		path: '/message_wall/edit',
		name: '/message_wall_edit',
		component: () => import('../views/message_wall/edit.vue')
	},
	//留言墙列表路由
	{
		path: '/message_wall/list',
		name: '/message_wall_list',
		component: () => import('../views/message_wall/list.vue')
	},
	//留言墙详情路由
	{
		path: '/message_wall/details',
		name: '/message_wall_details',
		component: () => import('../views/message_wall/details.vue')
	},
	//通知公告列表路由
	{
		path: '/notice_announcement/list',
		name: '/notice_announcement_list',
		component: () => import('../views/notice_announcement/list.vue')
	},
	//通知公告详情路由
	{
		path: '/notice_announcement/details',
		name: '/notice_announcement_details',
		component: () => import('../views/notice_announcement/details.vue')
	},
	//招聘信息列表路由
	{
		path: '/recruitment_information/list',
		name: '/recruitment_information_list',
		component: () => import('../views/recruitment_information/list.vue')
	},
	//招聘信息详情路由
	{
		path: '/recruitment_information/details',
		name: '/recruitment_information_details',
		component: () => import('../views/recruitment_information/details.vue')
	},
	//简历信息添加路由
	{
		path: '/resume_information/edit',
		name: '/resume_information_edit',
		component: () => import('../views/resume_information/edit.vue')
	},

	// 用户路由
	{
		path: '/user/index',
		name: 'user_index',
		component: () => import('../views/user/index.vue')
	},
	// 基本信息
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue')
	},
	// 找回密码
	{
		path: '/user/password',
		name: 'user_password',
		component: () => import('../views/user/password.vue')
	},

	// 搜索
	{
		path: '/search',
		name: 'search',
		component: () => import('../views/search/index.vue')
	},
	// 局部搜索
	{
		path: '/search/details',
		name: 'search_details',
		component: () => import('../views/search/details.vue')
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.afterEach((to, from, next) => {
	let title = "学生就业管理系统-home";
	document.title = title;
	document.logo = "学生就业管理系统"
})

export default router
