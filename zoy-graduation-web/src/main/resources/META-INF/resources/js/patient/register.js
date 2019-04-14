/**
 * 患者注册页面
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
            this.$infoForm = $("#form-info");

            // ·按钮btn
            this.$btnCommit = $("#commit-reg")
		},
		// ·绑定事件
		bindEvents : function() {
			this.$btnCommit.on("click", App.commit);
		},
        // ·提交注册信息
		register : function () {
			$.ajax({
				url : CTX + "/patient/register",
				type : "POST",
				dataType : 'json',
				cache : false,
                success: function(data) {
                    //返回的数据用data.d获取内容
                    alert(data.d);
                },
                error: function(err) {
                    alert(err);
                }
			})
        }
	};
    App.init();
})(jQuery, window, ZOY);