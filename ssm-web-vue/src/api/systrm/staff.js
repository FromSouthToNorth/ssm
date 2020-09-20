import request from '@/utils/request'

// 查询员工列表
export function staff(query) {
  return request({
    url: '/staff/list',
    method: 'get',
    params: query
  })
}

// 新增员工
export function addStaff(data) {
  return request({
    url: '/staff',
    method: 'post',
    data: data
  })
}
