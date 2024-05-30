/* ----------------------------------
jQuery Timelinev 1.1.0
tested with jQuery v2.2.4

Copyright 2017, Created by Xavier Raspall Gonzalez
Free under the MIT license.
http://www.opensource.org/licenses/mit-license.php
---------------------------------- */

jQuery.fn.timelinev = function(options){
    // plugin settings
    settings = jQuery.extend({
        timelineDiv: 	 $(this),
        containerDivs: 	 '.timelineCont',
        dateDiv: 		 '.date',
        textDiv: 		 '.text',
        dateHtml: 		 'h2',
        textHtml: 		 'p',
        dateActiveClass: '.active',
        datesSpeed:      '750',
    }, options);
        
    console.log();

    $(function() {
        // setting variables
        var divsCont    = settings.timelineDiv.find(settings.containerDivs);
        var datesCont   = divsCont.find(settings.dateDiv+' '+settings.dateHtml);
        var dates       = parseFecha(datesCont);
        var dateActive  = dates.indexOf($(settings.dateActiveClass+' '+settings.dateDiv+' '+settings.dateHtml).html());

        var divHeight   = divsCont.outerHeight();

        //Show date active
        if (dateActive>1) {
            for (i = 0; i < dateActive-1; i++) {
                $(divsCont[i]).css('margin-top', -divHeight );
            }
        }

        //Bind click on date
        // $(settings.containerDivs).find(settings.dateDiv).click(function(event){
        //     event.preventDefault();
        //     var dateSelected = $(this).find(settings.dateHtml);
        //     var posDate = dates.indexOf(dateSelected.html());
        
        //     if (!$(this).parent().hasClass('active')) {
        //         divsCont.removeClass('active');
        //         $(this).parent().addClass('active');
        //         dateActive = posDate;
        //     } else {
        //         $(this).parent().removeClass('active');
        //         dateActive = -1; // Reset dateActive to indicate no active date
        //     }
        // });

        $(settings.containerDivs).find(settings.dateDiv).click(function(event){
            event.preventDefault();
            var dateSelected = $(this).find(settings.dateHtml);
            var posDate = dates.indexOf(dateSelected.html());

            var idSelected = $(this).attr('id'); // 获取被点击元素的 id 属性
            var departmentSelected = $(this).attr('department');
            console.log("Selected ID: " + idSelected);
            console.log("Selected department: " + departmentSelected);

            if (!$(this).parent().hasClass('active')) {
                // 移除所有容器的激活狀態
                divsCont.removeClass('active');
                // 添加目前容器的激活狀態
                $(this).parent().addClass('active');
                dateActive = posDate;
            } else {
                // 取消目前容器的激活狀態
                $(this).parent().removeClass('active');
                dateActive = -1; // 重置dateActive表示沒有激活的日期
            }

            $.ajax({
                url: '/timeline/getDateDetails', // 替換為伺服器端對應的URL
                type: 'GET',
                data: {
                    id: idSelected,
                    department: departmentSelected
                },
                success: function(response) {
                    // 在這裡處理伺服器返回的資料，例如顯示在對應的日期框中
                    $('#date-box-' + idSelected).html(response);
                },
                error: function(xhr, status, error) {
                    console.error("AJAX Error: " + status + error);
                }
            });
        });

        
        
        
        //Bind scroll
        // settings.timelineDiv.bind('mousewheel DOMMouseScroll', function (event) {
        //     event.preventDefault();

        //     if ((event.originalEvent.wheelDelta > 0 || event.originalEvent.detail < 0) && (dateActive-1)!==0) {
        //         divsCont.removeClass('active');
        //         $(divsCont[(dateActive-1)]).addClass('active');

        //         incrementDate();
        //         dateActive=dateActive-1;

        //     }

        //     if ((event.originalEvent.wheelDelta < 0 || event.originalEvent.detail > 0) && (dateActive+1)!==(dates.length-1)){
        //         divsCont.removeClass('active');
        //         $(divsCont[(dateActive+1)]).addClass('active');

        //         if ((dateActive+1)!=(divsCont.length-2)){
        //             decrementDate();
        //         }

        //         dateActive=dateActive+1;
        //     }
        // });

        //Parse dates
        function parseFecha(fechasHTML) {
            var arrayDates = [];
            fechasHTML.each(function(){
                var singleDate = $(this).html();
                arrayDates.push(singleDate);
            });
            return arrayDates;
        }

        // //Increment
        // function incrementDate(){
        //     $(divsCont[(dateActive-1)]).animate({ 'margin-top': 0 }, {queue:true, duration:'settings.datesSpeed'});
        //     $(divsCont[(dateActive-2)]).animate({ 'margin-top': 0 }, {queue:true, duration:'settings.datesSpeed'});
        // }

        // //Decrement
        // function decrementDate(){
        //     $(divsCont[dateActive-1]).animate({ 'margin-top': "-"+divHeight  }, {queue:true, duration:'settings.datesSpeed'});
        // }

    });
};
