<template>
  <div class="diy_edit page_message_wall" id="message_wall_edit">
    <div class='warp'>
      <div class='container'>
        <div class='row'>
          <div class="col-12 col-md-6">
            <div class="diy_title">
							<span>留言标题:
							</span>
            </div>
            <!-- 文本 -->
            <div class="diy_field diy_text">
              <input type="text" id="form_message_title" v-model="form['message_title']" placeholder="请输入标题"/>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="diy_title">
							<span>留言时间:
							</span>
            </div>
            <!-- 日期 -->
            <div class="diy_field diy_date">
              <input type="date"  id="form_message_time"
                     v-model="form['message_time']" placeholder="请输入留言时间"/>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="diy_title">
							<span>留言人:
							</span>
            </div>
            <div class="diy_field diy_down">
              <!-- 文本 -->
              <div class="diy_field diy_text">
                <input type="text" id="form_message_title" v-model="form['message_person']" placeholder="请输入留言人名字"/>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="diy_title">
							<span>留言内容:
							</span>
            </div>
            <!-- 多文本 -->
            <div class="diy_field diy_desc">
              <textarea id="form_message_content" v-model="form['message_content']" style="width: 380px;"/>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="diy_title">
							<span>封面:
							</span>
            </div>
            <!-- 图片 -->
            <input type="file" style="display: none;" id="form_img_cover"
                   title="cover" @change="change_file($event.target.files,'cover')"/>
            <div class="diy_field diy_img" onclick="document.getElementById('form_img_cover').click()">
              <img :src="$fullUrl(form['cover'])"/>
            </div>
            <!-- 修改权限 -->
<!--            <div class="diy_field diy_img" v-if="form['cover'] && $check_field('set','cover')">-->
<!--              <label for="form_img_cover">-->
<!--                <img :src="$fullUrl(form['cover'])"/>-->
<!--              </label>-->
<!--            </div>-->
            <!-- 添加权限 -->
<!--            <div class="diy_field diy_img" v-else-if="!form['cover'] && $check_field('add','cover')">-->
<!--              <label for="form_img_cover">-->
<!--                <div class="btn_add_img">-->
<!--                  <span>+</span>-->
<!--                </div>-->
<!--              </label>-->
<!--            </div>-->
            <!-- 查询权限 -->
<!--            <div class="diy_field diy_img" v-else-if="$check_field('get','cover')">-->
<!--              <img :src="$fullUrl(form['cover'])"/>-->
<!--            </div>-->

          </div>

        </div>
        <div class="row">
          <div class="col-12">
            <div class="btn_box">
              <button style="position: relative; left: 450px;" class="btn_submit" @click="submit_New()">提交</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import mixin from "@/mixins/page.js";

export default {
  mixins: [mixin],
  components: {},
  data() {
    return {
      url_get_obj: "~/api/message_wall/get_obj?",
      url_add: "~/api/message_wall/add?",
      url_set: "~/api/message_wall/set?",

      // 登录权限
      oauth: {
        "signIn": true,
        "user_group": []
      },

      // 查询条件
      query: {
        "message_title": "",
        "message_time": "",
        "message_person": 0,
        "message_content": "",
        "cover": "",
        "message_wall_id": 0,
      },

      obj: {
        "message_title": '', // 留言标题
        "message_time": "1970-01-01 00:00:00",
        "message_person": 0, // 留言人
        "message_content": '', // 留言内容
        "cover": '', // 封面
        "message_wall_id": 0,
      },

      // 表单字段
      form: {
        "message_title": '', // 留言标题
        "message_time": "1970-01-01 00:00:00",
        "message_person": 0, // 留言人
        "message_content": '', // 留言内容
        "cover": '', // 封面
        "message_wall_id": 0,

      },
      disabledObj: {
        "message_title_isDisabled": false,
        "message_time_isDisabled": false,
        "message_person_isDisabled": false,
        "message_content_isDisabled": false,
        "cover_isDisabled": false,
      },
      // 用户列表
      list_user_message_person: [],

      // ID字段
      field: "message_wall_id",
    }
  },
  methods: {
    submit_New(){
      var url = this.$fullUrl(this.url_add)
      const { message_wall_id, ...newForm } = this.form;
      console.log("url-->",url)
      console.log("newForm-->",newForm)
      var param = newForm;
      this.$post(url, param, function(json, status) {
        this.$toast('提交成功！', 'success');
      });
    },
    /**
     * 获取学生用户列表
     */
    async get_list_user_message_person() {
      // if(this.user_group !== "管理员" && this.form["message_person"] === 0) {
      //     this.form["message_person"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=学生");
      if (json.result && json.result.list) {
        this.list_user_message_person = json.result.list;
      } else if (json.error) {
        console.error(json.error);
      }
    },
    async get_user_session_message_person() {
      var _this = this;
      var json = await this.$get("~/api/user_group/get_obj?name=学生");
      if (json.result && json.result.obj) {
        // var source_table = json.result.obj.source_table;
        var source_table = 'message_wall'
        var user_id = _this.$store.state.user.user_id;
        if (user_id) {
          var url = "~/api/" + source_table + "/get_obj?"
          this.$get(url, {"message_wall_id": _this.$store.state.user.user_id}, function (res) {
            if (res.result && res.result.obj) {
              var arr = []
              for (let key in res.result.obj) {
                arr.push(key)
              }
              var arrForm = []
              for (let key in _this.form) {
                arrForm.push(key)
              }
              _this.form["message_person"] = user_id
              _this.disabledObj['message_person' + '_isDisabled'] = true
              for (var i = 0; i < arr.length; i++) {
                for (var j = 0; j < arrForm.length; j++) {
                  if (arr[i] === arrForm[j]) {
                    if (arr[i] !== "message_person") {
                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                      break;
                    }
                  }
                }
              }
            }
          });
        }
      } else if (json.error) {
        console.error(json.error);
      }
    },

    /**
     * 修改文件
     * @param { Object } files 上传文件对象
     * @param { String } str 表单的属性名
     */
    change_file(files, str) {
      var form = new FormData();
      form.append("file", files[0]);
      this.$post("~/api/message_wall/upload?", form, (res) => {
        if (res.result) {
          this.form[str] = res.result.url;
        } else if (res.error) {
          this.$toast(res.error.message);
        }
      });
    },

    /**
     * 获取对象后获取缓存表单
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_before(param) {
      var form = $.db.get("form");
      if (form) {
        this.obj = $.push(this.obj, form);
        this.form = $.push(this.form, form);
      }
      var arr = []
      for (let key in form) {
        arr.push(key)
      }
      for (var i = 0; i < arr.length; i++) {
        this.disabledObj[arr[i] + '_isDisabled'] = true
      }
      this.form["message_time"] = this.$toTime(parseInt(this.form["message_time"]), "yyyy-MM-dd")
      return param;
    },

    /**
     * 获取对象后获取缓存表单
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func) {
      var form = $.db.get("form");
      var obj = Object.assign({}, form, this.obj);
      if (form) {
        this.obj = $.push(this.obj, obj);
      }
      if (form) {
        this.form = $.push(this.form, form);
      }
      if (func) {
        func(json);
      }
    },

  },
  created() {
    this.get_user_session_message_person();
    this.get_list_user_message_person();
  }
}
</script>

<style>
</style>
