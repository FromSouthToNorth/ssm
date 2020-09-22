import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ssm";

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


// 查询员工详细
export function getStaff(staffId) {
  return request({
    url: '/staff/' + praseStrEmpty(staffId),
    method: 'get'
  })
}

// 修改员工
export function updateStaff(data) {
  return request({
    url: '/staff',
    method: 'put',
    data: data
  })
}

// 删除员工
export function deleteStaff(staffId) {
  return request({
    url: '/staff/' + staffId,
    method: 'delete'
  })
}
