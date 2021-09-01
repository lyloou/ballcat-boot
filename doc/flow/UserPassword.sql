START TRANSACTION;

-- 目录ID
set @pId = 140000;
-- 菜单ID
set @menuId = 140300;

-- 插入菜单
INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId, @pId, '用户密码', NULL, NULL, 'user-password', 1, NULL, 1, 0, 0, 0, NULL, 0, NOW(), NOW());


-- 菜单对应按钮SQL
INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 1, @menuId, '用户密码查询', NULL, 'flow:user-password:read', 'userpassword', 1, NULL, 1, 0, 0, 2, NULL, 0,
        NOW(), NOW());

INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 2, @menuId, '用户密码新增', NULL, 'flow:user-password:add', 'userpassword', 1, NULL, 2, 0, 0, 2, NULL, 0,
        NOW(), NOW());


INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 3, @menuId, '用户密码修改', NULL, 'flow:user-password:edit', 'userpassword', 1, NULL, 3, 0, 0, 2, NULL, 0,
        NOW(), NOW());


INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 4, @menuId, '用户密码删除', NULL, 'flow:user-password:del', 'userpassword', 1, NULL, 4, 0, 0, 2, NULL, 0,
        NOW(), NOW());

-- 清空变量
set @menuId = null;
set @pId = null;

COMMIT;