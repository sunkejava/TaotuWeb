function parse(){
			var rtrp = "search.jsp?search="+getDOM('inputv').value;
			window.location.href = rtrp;
		}
var getDOM = function(id){
			return document.getElementById(id);
		}
function saonloadp(search,startnums,Pages){
				var inse = "";
					for(var i=0;i<4;i++){
						if(i==0){
							if(startnums-1==0){
								inse = "<a href='?search="+search+"&page=1'>首页</a><a href='?search="+search+"&page="+1+"'  class='page-prev'>上一页</a>";
							}else{
								inse = "<a href='?search="+search+"&page=1'>首页</a><a href='?search="+search+"&page="+(startnums-1)+"'  class='page-prev'>上一页</a>";
							}
						}else if(i==1){
							inse = inse+"<a href='?search="+search+"&page="+startnums+"'  class='current'>"+startnums+"</a>";
						}else if(i==2){
							if(startnums>=Pages){
								inse = inse+"<a href='?search="+search+"&page="+Pages+"' class='page-next'>下一页</a><a href='?search="+search+"&page="+Pages+"'>末页</a>";
							}else{
								inse = inse+"<a href='?search="+search+"&page="+(startnums+1)+"' class='page-next'>下一页</a><a href='?search="+search+"&page="+Pages+"'>末页</a>";
							}
							
						}else{
							inse = inse+"<a class='text'>"+startnums+"/"+Pages+"</a>";
						}
					}
				$(document).ready(function(){
					$("#pagnation").find("div").append(inse);
				});
				$("#pagnation").show();
			}
function aonloadp(startnums,Pages){
				var inse = "";
					for(var i=0;i<4;i++){
						if(i==0){
							if(startnums-1==0){
								inse = "<a href='?page=1'>首页</a><a href='?page="+1+"'  class='page-prev'>上一页</a>";
							}else{
								inse = "<a href='?page=1'>首页</a><a href='?page="+(startnums-1)+"'  class='page-prev'>上一页</a>";
							}
						}else if(i==1){
							inse = inse+"<a href='?page="+startnums+"'  class='current'>"+startnums+"</a>";
						}else if(i==2){
							if(startnums>=Pages){
								inse = inse+"<a href='?page="+Pages+"' class='page-next'>下一页</a><a href='?page="+Pages+"'>末页</a>";
							}else{
								inse = inse+"<a href='?page="+(startnums+1)+"' class='page-next'>下一页</a><a href='?page="+Pages+"'>末页</a>";
							}
							
						}else{
							inse = inse+"<a class='text'>"+startnums+"/"+Pages+"</a>";
						}
					}
				$(document).ready(function(){
					$("#pagnation").find("div").append(inse);
				});
				$("#pagnation").show();
			}

$(window).resize(function(){
    var container = $('#images .items');
    var masonryContainer = $('#images');
    container.imagesLoaded(function(){
        container.fadeIn();
        masonryContainer.masonry({
            itemSelector : '.items',
            isAnimated: true
        });
    });
})

//masonry
/*
$(document).ready(
    function() {
        var container = $('#images .items');
        var masonryContainer = $('#images');
        container.imagesLoaded(function(){
            container.fadeIn();
            masonryContainer.masonry({
                itemSelector : '.items',
                isAnimated: true
            });
        });
    }
);
*/
    
/////////////////////////////////////////////////////////////////////////////////////////////////////



$(function() {
    var loadurl = '@c=mobile-pic&a=load', loaded = false, sTimer, onloading = false;
    var jWindow = $(window), container = $("#images .items"), masonryContainer = $('#images');
    var jLoading = $('#loading');
    function loadMore() {
        if (loaded == 1) return;
        onloading = true;
        jLoading.show();
        $.getJSON(loadurl, {'tag' : tagId, 'offset': offset, math: Math.random() }, function(json){
            if('undefined' == json || json.enabled ==0){
                loaded = 1;
            }else{
                var options = masonryContainer.data("masonry").options, bakAnimated = options.isAnimated;
                options.isAnimated = false;
                masonryContainer.append(json.html).masonry("reload");
                offset = json.offset;
                options.isAnimated = bakAnimated;
            }
            tagShow();
            jLoading.hide();

            onloading = false;
        });
    }

    function tagShow() {
        $("#images .items").imagesLoaded(function(){
            $("#images .items:hidden").fadeIn();
            masonryContainer.masonry({
                itemSelector : '.items',
                isAnimated: true
            });
        });
    }

    tagShow();
    $(window).scroll(function scrollHandler(){
        if (onloading) {
            return;
        }
        clearTimeout(sTimer);
        sTimer = setTimeout(function() {
            if(loaded == 1){$(window).unbind("scroll", scrollHandler);}
            var c=document.documentElement.clientHeight || document.body.clientHeight, t=$(document).scrollTop();
            if(t+c >= masonryContainer.offset().top+masonryContainer.height()){loadMore();}
        }, 100);
    });
});
