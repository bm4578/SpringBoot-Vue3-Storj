import request from '../utils/request.js'
import qs from 'qs';

export function convert_List(data){
    return request({
        url:'/api/',
        method:"post",
        data:qs.stringify(data)
    })
}