/**
 * 患者主页面
 */
(function($, window, ZOY, undefined) {
	'use strict';

	var App = {
		init : function() {
			this.catheElements();
			this.bindEvents();
			this.renderTable();
			this.fillPatientId();
		},
		// ·DOM对象
		catheElements : function() {
            this.$patientId = $("#patient-id");
            // ·按钮btn
            this.$btnSearch = $("#btn-search");
			// ·table
			this.$tableCaseInfo = $("#table-case-info");
		},
		// ·绑定事件
		bindEvents : function() {
			this.$btnSearch.on("click", App.search);
		},
        renderTable : function() {
			var _table = this.$tableCaseInfo;

			App.$caseInfoDataTable = _table.DataTable(
				{
                    deferLoading: 0,
                    scrollX : true,
                    autoWidth : true,
                    bFilter : false,
                    bLengthChange: false,
                    serverSide : false,
					ajax : function (data, callback, settings) {
						// ·获取数据
                        var _param = App.getCondtion();
						// ·请求ajax
                        $.ajax({
                            url : CTX + "/case/info",
                            type : "POST",
                            dataType : 'json',
                            cache : false,
                            data : _param
                        }).done(function(response, textStatus, jqXHR) {
                            var records = {
                                draw : 2,
                                recordTotal : response.total,
                                recordsFiltered : response.total,
                                data : response.list
                            };
                            callback(records);
                        }).fail(
                            function(jqXHR, textStatus, errorThrown) {
                            });
                    },
                    columns : [
                        {
                            "data" : "medicineName",
                            "title":"药名"
                        }, // 0
                        {
                            "data" : "medicineNum",
                            "title":"数量"
                        }, // 1
                        {
                            "data" : "doctorName",
                            "title":"医生姓名"
                        }, //2
                        {
                            "data" : "visitTime",
                            "title":"就诊时间",
                            render : function (data, type, row, meta) {
                                if(data == null){
                                    return "";
                                }else{
                                    return moment(data).format('YYYY-MM-DD');
                                }
                            }
                        } //3
                    ]
				});
		},
        getCondtion : function () {
            var _param = {};
            var _storage = localStorage.getItem("patient");
            var _parse = JSON.parse(_storage);
            if (_parse.patientId != null) {
                _param.patientId = _parse.patientId;
            }
            return _param;
        },
        fillPatientId : function () {
            var _storage = localStorage.getItem("patient");
            var _parse = JSON.parse(_storage);
            this.$patientId.val(_parse.patientId);
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