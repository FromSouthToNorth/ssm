import request from '@/utils/request'

// 查询的确列表
export function listAddress(query) {
  return request({
    url: '/address/list',
    method: 'get',
    params: query
  })
}
