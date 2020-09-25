import request from '@/utils/request';

// 查询服务器详情
export function getServerInfo() {
  return request({
    url: '/monitor/server',
    method: 'get'
  })
}