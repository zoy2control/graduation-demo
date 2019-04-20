/**
 * 医生修改密码
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
        // ·提交修改密码信息
		commit : function () {

			var _formData = App.getFormData($("#form-info")[0]);
			_formData = App.getCondtion(_formData);


			$.ajax({
				url : CTX + "/doctor/modify/password",
				type : "POST",
				dataType : 'json',
				cache : false,
				data : _formData,
                success: function(data) {
				    // ·注册成功之后，跳转登录界面
				    window.location.href = CTX + "/hello/index"
                },
                error: function(err) {
                    window.location.href = CTX + "/hello/index"
                }
			})
        },

        getCondtion : function (_formData) {
            var _storage = localStorage.getItem("doctor");
            var _parse = JSON.parse(_storage);
            if (_parse.doctorId != null) {
                _formData.doctorId = _parse.doctorId;
            }
            return _formData;
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