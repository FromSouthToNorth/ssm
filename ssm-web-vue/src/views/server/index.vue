<template>
  <div class="app-container">
    <el-row>
      <el-col :span="12" class="card-box">
        <el-card>
          <div slot="header"><span>CPU</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="is-leaf"><div class="cell">属性</div></th>
                <th class="is-leaf"><div class="cell">值</div></th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td><div class="cell">核心数</div></td>
                <td><div class="cell" v-if="server.cpu">{{ server.cpu.cpuNum }}</div></td>
              </tr>
              <tr>
                <td><div class="cell">用户使用率</div></td>
                <td><div class="cell" v-if="server.cpu">{{ server.cpu.used }}%</div></td>
              </tr>
              <tr>
                <td><div class="cell">系统使用率</div></td>
                <td><div class="cell" v-if="server.cpu">{{ server.cpu.sys }}%</div></td>
              </tr>
              <tr>
                <td><div class="cell">当前空闲率</div></td>
                <td><div class="cell" v-if="server.cpu">{{ server.cpu.free }}%</div></td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :span="12" class="card-box">
        <el-card>
          <div slot="header"><span>内存</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="is-leaf"><div class="cell">属性</div></th>
                <th class="is-leaf"><div class="cell">内存</div></th>
                <th class="is-leaf"><div class="cell">JVM</div></th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td><div class="cell">总内存</div></td>
                <td><div class="cell" v-if="server.mem">{{ server.mem.total }}G</div></td>
                <td><div class="cell" v-if="server.jvm">{{ server.jvm.total }}M</div></td>
              </tr>
              <tr>
                <td><div class="cell">已用内存</div></td>
                <td><div class="cell" v-if="server.mem">{{ server.mem.used}}G</div></td>
                <td><div class="cell" v-if="server.jvm">{{ server.jvm.used}}M</div></td>
              </tr>
              <tr>
                <td><div class="cell">剩余内存</div></td>
                <td><div class="cell" v-if="server.mem">{{ server.mem.free }}G</div></td>
                <td><div class="cell" v-if="server.jvm">{{ server.jvm.free }}M</div></td>
              </tr>
              <tr>
                <td><div class="cell">使用率</div></td>
                <td><div class="cell" v-if="server.mem" :class="{'text-danger': server.mem.usage > 80}">{{ server.mem.usage }}%</div></td>
                <td><div class="cell" v-if="server.jvm" :class="{'text-danger': server.jvm.usage > 80}">{{ server.jvm.usage }}%</div></td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :span="24" class="card-box">
        <el-card>
          <div slot="header">
            <span>服务器信息</span>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <tbody>
              <tr>
                <td><div class="cell">服务器名称</div></td>
                <td><div class="cell" v-if="server.sys">{{ server.sys.computerName }}</div></td>
                <td><div class="cell">操作系统</div></td>
                <td><div class="cell" v-if="server.sys">{{ server.sys.osName }}</div></td>
              </tr>
              <tr>
                <td><div class="cell">服务器IP</div></td>
                <td><div class="cell" v-if="server.sys">{{ server.sys.computerIp }}</div></td>
                <td><div class="cell">系统架构</div></td>
                <td><div class="cell" v-if="server.sys">{{ server.sys.osArch }}</div></td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :span="24" class="card-box">
        <el-card>
          <div slot="header">
            <span>Java虚拟机信息</span>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <tbody>
              <tr>
                <td><div class="cell">Java名称</div></td>
                <td><div class="cell" v-if="server.jvm">{{ server.jvm.name }}</div></td>
                <td><div class="cell">Java版本</div></td>
                <td><div class="cell" v-if="server.jvm">{{ server.jvm.version }}</div></td>
              </tr>
              <tr>
                <td><div class="cell">启动时间</div></td>
                <td><div class="cell" v-if="server.jvm">{{ server.jvm.startTime }}</div></td>
                <td><div class="cell">运行时长</div></td>
                <td><div class="cell" v-if="server.jvm">{{ server.jvm.runTime }}</div></td>
              </tr>
              <tr>
                <td colspan="1"><div class="cell">安装路径</div></td>
                <td colspan="3"><div class="cell" v-if="server.jvm">{{ server.jvm.home }}</div></td>
              </tr>
              <tr>
                <td colspan="1"><div class="cell">项目路径</div></td>
                <td colspan="3"><div class="cell" v-if="server.sys">{{ server.sys.userDir }}</div></td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :span="24" class="card-box">
        <el-card>
          <div slot="header">
            <span>磁盘状态</span>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <el-table
                :data="server.sysFiles"
                style="width: 100%">
              <el-table-column
                  prop="dirName"
                  label="盘符路径">
              </el-table-column>
              <el-table-column
                  prop="sysTypeName"
                  label="文件系统">
              </el-table-column>
              <el-table-column
                  prop="typeName"
                  label="盘符类型">
              </el-table-column>
              <el-table-column
                  prop="total"
                  label="总大小">
              </el-table-column>
              <el-table-column
                  prop="free"
                  label="可用大小">
              </el-table-column>
              <el-table-column
                  prop="used"
                  label="已用大小">
              </el-table-column>
              <el-table-column
                  prop="usage"
                  label="已用百分比">
              </el-table-column>
              <el-table-column
                  prop="usage"
                  label="已用百分比"
                  width="100"
                  filter-placement="bottom-end">
                <template slot-scope="scope">
                  <el-tag
                      :type="scope.row.usage > 80 ? 'danger' : 'success'"
                      disable-transitions>{{scope.row.usage}} %</el-tag>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getServerInfo } from "@/api/monitor/server";

export default {
  name: "server",
  data() {
    return {
      // 加载层信息
      loading: [],
      // 服务器信息
      server: []
    };
  },
  created() {
    this.getList();
    this.openLoading();
  },
  methods: {
    /** 获取服务器信息 */
    getList() {
      getServerInfo().then(response => {
        this.server = response.data;
        this.loading.close();
      })
    },
    // 打开加载层
    openLoading() {
      this.loading = this.$loading({
        lock: true,
        text: "拼命读取中",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)"
      });
    }
  }
}
</script>

<style scoped>

</style>