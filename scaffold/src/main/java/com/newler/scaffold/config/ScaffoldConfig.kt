package com.newler.scaffold.config

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import com.newler.scaffold.config.modlue.GlobalConfigModule

/**
 *
 * @what 脚手架全局配置
 * @author 17173
 * @date 2020/1/9
 *
 */
interface ScaffoldConfig {
    fun applyOptions(@NonNull application: Application,  @NonNull builder: GlobalConfigModule.Builder) : GlobalConfigModule
}