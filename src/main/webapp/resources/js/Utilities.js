function addEvent(el,event,callback){
if('addEventListener' in  el){
el.addEventListener(event,callback,false);
}else{
el['e' + event + callback] = callback;
el[event + callback] = function(){
el['e' + event + callback](window.event);
};

el.attachEvent('on' + event, el[event + callback]);
}
}

function removeEvent(el, event, callback) {
  if ('removeEventListener' in el) {                      // If removeEventListener works
    el.removeEventListener(event, callback, false);       // Use it
  } else {                                                // Otherwise
    el.detachEvent('on' + event, el[event + callback]);   // Create IE fallback
    el[event + callback] = null;
    el['e' + event + callback] = null;
  }
}
