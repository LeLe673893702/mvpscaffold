package com.newler.scaffold.config

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
interface MvpScaffoldConfig {
    fun applyOptions(@NonNull context: Context,  @NonNull builder: GlobalConfigModule.Builder) : GlobalConfigModule
}