/**
 * 医生管理
 */
(function($, window, ZOY, undefined) {
	'use strict';

	var App = {
		init : function() {
			this.catheElements();
			this.bindEvents();
			this.renderTable();
		},
		// ·DOM对象
		catheElements : function() {
		    this.$tableDoctor = $("#table-doctor");
		    this.$btnAddDoctor = $("#btn-add-doctor");
		},
		// ·绑定事件
		bindEvents : function() {
            this.$btnAddDoctor.on("click", App.addDoctor)
		},
        addDoctor : function () {
            window.location.href = CTX + "/doctor/show/add"
        },
        renderTable : function () {

            var _table = this.$tableDoctor;

            App.$doctorInfoDataTable = _table.DataTable(
                {
                    deferLoading: 0,
                    scrollX : true,
                    autoWidth : true,
                    bFilter : false,
                    bLengthChange: false,
                    serverSide : false,
                    ajax : function (data, callback, settings) {
                        // ·请求ajax，查询所有医生信息
                        $.ajax({
                            url : CTX + "/doctor/query/all",
                            type : "POST",
                            dataType : 'json',
                            cache : false
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
                            "data" : "",
                            "title":"序号",
                            "render" : function(data, type, row, meta) {
                                return meta.row+1;
                            }
                        }, // 0
                        {
                            "data" : "name",
                            "title":"医生姓名"
                        }, // 1
                        {
                            "data" : "sex",
                            "title":"性别"
                        }, // 2
                        {
                            "data" : "age",
                            "title":"年龄"
                        }, // 3
                        {
                            "data" : "workAge",
                            "title":"工龄"
                        }, // 4
                        {
                            "data" : "jobTitle",
                            "title":"职称"
                        }, // 5
                        {
                            "data" : "department",
                            "title":"科室"
                        }, // 6
                        {
                            "data" : "doctorId",
                            "title":"操作",
                            render : function (data, type, row, meta) {
                                var html = template.render(
                                    "<a href= '" +
                                    "/doctor/show/update/" +
                                    row.doctorId
                                    +"' target='_blank' title='修改'>修改</a>"
                                );

                                var _href = "<a href= '" +
                                    "/doctor/delete/" +
                                    row.doctorId
                                    +"' target='_blank' title='删除'>删除</a>"

                                var $html = $(html);
                                $html.append(" | " + _href);

                                return $html.get(0).outerHTML;
                            }
                        } //
                    ]
                });

        }
	};
    App.init();
})(jQuery, window, ZOY);