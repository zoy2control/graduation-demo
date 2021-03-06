/**
 * 编辑医生
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
		    this.$name = $("#name");
            this.$age = $("#age");
		    this.$btnCommit = $("#btn-commit");
		},
		// ·绑定事件
		bindEvents : function() {
            this.$btnCommit.on("click", App.commit);
		},
        commit : function () {
            var _formData = App.getFormData($("#doctor-info")[0]);
            $.ajax({
                url : CTX + "/doctor/update",
                type : "POST",
                dataType : 'json',
                cache : false,
                data : _formData,
                success: function(data) {
                    // ·编辑成功后，跳转到医生管理页面
                    window.location.href = CTX + "/admin/show/doctor"
                },
                error: function(err) {
                    window.location.href = CTX + "/admin/show/doctor"
                }
            })
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