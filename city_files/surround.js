/* 周边推荐 */
function surround(o){
    o=o||{};
    this.city=o.city;
    if (!this.city) {
        try{
            this.city = document.cookie.match(/(^|\s|;)ipcity=\w*/)[0].split("=")[1];
        }catch(e){
            return;
        }
    }
    this.cate = o.cate||'';
    this.cateName = o.cateName||'';
    this.id=o.id||'around';
    this.size=o.size;//显示个数限制，空-全部
    this.result=null;
    this.init();
}
surround.prototype={
    init:function(){
        var _this = this; 
        window.aroundback = function(data){
            if(!data) return;
            if(Object.prototype.toString.call(data) != '[object Array]') return;
            _this.result=data;
            _this.show();
        }
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = 'http://api.58.com/comm/nearCities-'+this.city+'?api_callback=aroundback&_='+new Date().getTime();
        document.body.appendChild(script); 
    },
    show:function(){
        var oAround = document.getElementById(this.id);
        var htmlArr = [oAround.innerHTML];
        for (var i=0,len=this.result.length; i < len; i++) {
            if(i == this.size) break;
            htmlArr.push('<a href="http://'+this.result[i].city+'.58.com/'+this.cate+'" onclick="co(\''+this.result[i].city+'\')">'+this.result[i].name+this.cateName+'</a>');
        }
        oAround.innerHTML=htmlArr.join('');
        oAround.style.display='block';
    }
}

var CityEventUtil = {
    addHandler : function(element,type,handler){
        if(element.addEventListener){
            element.addEventListener(type,handler,false);
        }else if(element.attachEvent){
            element.attachEvent("on"+type,handler);
        }else{
            element["on"+type]=handler;
        }
    },

    removeHandler : function(element,type,handler){
        if(element.removeEventListener){
            element.removeEventListener(type,handler,false);
        }else if(element.detachEvent){
            element.detachEvent("on"+type,handler);
        }else{
            element["on"+type]=null;
        }
    },

    getEvent : function(event){
        return event?event:window.event;
    },

    getTarget : function(event){
        return event.target||event.srcElement;
    }
};
function cityInputFocus(){
    clickLog('from=citySearchInput_focus');
}
function cityBtnClick(event){
    clickLog('from=citySearchInput_use');
}
function cityInputEnter(event){
    event = CityEventUtil.getEvent(event);
    if(event.keyCode==13){
        clickLog('from=citySearchInput_use');
    }
}
//input获得焦点
CityEventUtil.addHandler($("_cityinput"),'focus',cityInputFocus);
//点击模糊匹配城市
CityEventUtil.addHandler($("_citybtn"),'click',cityBtnClick);
//input回车
CityEventUtil.addHandler($("_cityinput"),'keydown',cityInputEnter);
