START TRANSACTION;

-- 目录ID
set @pId = 140000;
-- 菜单ID
set @menuId = 140200;

-- 插入菜单
INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId, @pId, '用户', NULL, NULL, 'user', 1, NULL, 1, 0, 0, 0, NULL, 0, NOW(), NOW());


-- 菜单对应按钮SQL
INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 1, @menuId, '用户查询', NULL, 'flow:user:read', 'user', 1, NULL, 1, 0, 0, 2, NULL, 0, NOW(), NOW());

INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 2, @menuId, '用户新增', NULL, 'flow:user:add', 'user', 1, NULL, 2, 0, 0, 2, NULL, 0, NOW(), NOW());


INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 3, @menuId, '用户修改', NULL, 'flow:user:edit', 'user', 1, NULL, 3, 0, 0, 2, NULL, 0, NOW(), NOW());


INSERT INTO `sys_menu`
(`id`, `parent_id`, `title`, `icon`, `permission`, `path`, `target_type`, `uri`, `sort`, `keep_alive`, `hidden`, `type`,
 `remarks`, `deleted`, `create_time`, `update_time`)
VALUES (@menuId + 4, @menuId, '用户删除', NULL, 'flow:user:del', 'user', 1, NULL, 4, 0, 0, 2, NULL, 0, NOW(), NOW());

-- 清空变量
set @menuId = null;
set @pId = null;

COMMIT;