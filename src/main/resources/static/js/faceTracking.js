var saveArray = {};
window.onload = function () {
    var video = document.getElementById('video');
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext('2d');

    var tracker = new tracking.ObjectTracker('face');
    tracker.setInitialScale(4);
    tracker.setStepSize(2);
    tracker.setEdgesDensity(0.1);

    tracking.track('#video', tracker, {camera: true});

    tracker.on('track', function (event) {
        context.clearRect(0, 0, canvas.width, canvas.height);

        event.data.forEach(function (rect) {
            context.strokeStyle = '#fff';
            context.strokeRect(rect.x, rect.y, rect.width, rect.height);
            context.fillStyle = "#fff";
            saveArray.x = rect.x;
            saveArray.y = rect.y;
            saveArray.width = rect.width;
            saveArray.height = rect.height;
        });
    });
    setInterval(function () {
        //console.log(saveArray);
        if (saveArray.x > 200 &&
            saveArray.x + saveArray.width < 400 &&
            saveArray.y > 120 &&
            saveArray.y + saveArray.height < 320 &&
            saveArray.width < 180
            && saveArray.height < 180) {
            console.log(saveArray);
            getPhoto();
            for (var key in saveArray) {
                delete saveArray[key];
            }
        }
    }, 2000);
    function getPhoto() {
        context2.drawImage(video, 210, 130, 210, 210, 0, 0, 140, 140); //将video对象内指定的区域捕捉绘制到画布上指定的区域，实现拍照。
    }
    //截图
    var btn = document.getElementById("btn");
    btn.onclick= function () {
        getPhoto();
    }
    var canvas1 = document.getElementById('canvas1');
    var context1 = canvas1.getContext('2d');
    var can = document.getElementById('shortCut');
    var context2 = can.getContext('2d');
    context1.strokeStyle = "#69fff1";
    context1.moveTo(190, 118);
    context1.lineTo(390, 118);
    context1.lineTo(390, 318);
    context1.lineTo(190, 318);
    context1.lineTo(190, 118);
    context1.stroke();


    var img = document.getElementById("img");
    //将canvas转化为图片
    function convertCanvasToImage(canvas) {
        var image = new Image();
        image.src = canvas.toDataURL("image/png");
        return image;
    }
    //保存图片
    var keepImg = document.getElementById("keepImg");
    keepImg.onclick = function () {
        $.support.cors = true;
        var photoImg = document.createElement("img");
        photoImg.src = convertCanvasToImage(can).src;
        img.appendChild(photoImg);
        //获取到转化为base64的图片地址
        console.log(convertCanvasToImage(can).src);
        $.ajax({
            url:"/face/faceTracking.json",    //请求的url地址
            dataType:"json",   //返回格式为json
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
            data:{"base64":convertCanvasToImage(can).src},    //参数值为base64
            type:"post",   //请求方式
            beforeSend:function(){
                //请求前的处理
            },
            success:function(req){
                //请求成功时处理
                $.messager.alert("提示","签到成功！","warning");
            },
            complete:function(){
                //请求完成的处理
            },
            error:function(){
                //请求出错处理
            }
        });
    }
    //拍照
};
