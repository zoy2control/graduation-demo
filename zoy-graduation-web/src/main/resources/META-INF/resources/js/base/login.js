/**
 * 主登录页面
 */
(function($, window, ZOY, undefined) {
	'use strict';

	var App = {
		init : function() {
			this.catheElements();
			this.bindEvents();
		},
		// ·DOM对象
		catheElements : function() {
			// ·Form表单
            this.$loginForm = $("#form-account");

            // ·按钮btn
            this.$btnLogin = $("#btn-login")
			this.$btnRegister = $("#btn-register");
		},
		// ·绑定事件
		bindEvents : function() {
			this.$btnLogin.on("click", App.login);
			this.$btnRegister.on("click", App.register);

		},
		// ·登录
		login : function () {
            var _formData = App.getFormData($("#form-account")[0]);
            $.ajax({
                url : CTX + "/hello/login",
                type : "POST",
                dataType : 'json',
                cache : false,
                data : _formData,
				// ·登录成功之后，跳转到相对应的主界面
                success: function(data) {
                    if(data != null && data.privilege === 0) {// ·管理员主界面
                        localStorage.setItem("admin",data);
                    	window.location.href = CTX + "/admin/home";
					} else if (data != null && data.privilege === 1) {// ·医生主界面
                        var _data = JSON.stringify(data);
                        localStorage.setItem("doctor",_data);
                    	window.location.href = CTX + "/doctor/home";
					} else if (data != null && data.privilege === 2) {// ·患者主界面
                        var _data = JSON.stringify(data);
                        localStorage.setItem("patient",_data);
                    	window.location.href = CTX + "/patient/home";
					} else {
                        window.location.href = CTX + "/hello/error"
                    }
                },
                error: function(err) {
					alter(err);
                }
            })
        },
        // ·注册
		register : function () {
			// ·跳转至注册中心页面
			// window.location.href=CTX + '/hello/center/register';

            // ·跳转患者注册页面
            window.location.href=CTX + '/patient/show/register';
        },

        getFormData: function(target) {
            var _$target = target;
            var data = {};

            // 处理 input 表单
            $(_$target).find("input").each(function(index, ele) {
                var _$ele = $(ele);

                var _name = _$ele.prop("name");
                var _val = _$ele.val();

                data[_name] = _val;
            });

            // // 处理 select 表单
            // _$target.find(".s2-rendered").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     var _name = _$ele.attr("name");
            //     var _val = _$ele.select2("val");
            //
            //     data[_name] = _val;
            // });
            //
            // // 处理  radio 表单
            // _$target.find(".radio-rendered").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     if(_$ele.prop("checked") == true) {
            //         var _name = _$ele.prop("name");
            //         var _val = _$ele.val();
            //         data[_name] = _val;
            //     }
            // });
            //
            // // 处理  checkbox 表单
            // _$target.find(".checkbox-rendered").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     if(_$ele.prop("checked") == true) {
            //         var _name = _$ele.prop("name");
            //         var _val = _$ele.val();
            //         data[_name] = _val;
            //     }
            // });
            //
            // // 处理 textarea 表单
            // _$target.find("textarea").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     var _name = _$ele.attr("name");
            //     var _val = _$ele.val();
            //
            //     data[_name] = _val;
            // });
            return data;
        }
	};
    App.init();
})(jQuery, window, ZOY);