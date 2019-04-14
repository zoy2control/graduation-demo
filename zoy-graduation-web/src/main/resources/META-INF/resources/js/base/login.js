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
			this.$btnRegister.on("click", App.register)
		},
		// ·登录
		login : function () {
			var data = new FormData($('#form-account')[0]);
			return data;
        },
        // ·注册
		register : function () {
			// ·跳转至注册中心页面
			window.location.href=CTX + '/hello/center/register';
        }
	};
    App.init();
})(jQuery, window, ZOY);