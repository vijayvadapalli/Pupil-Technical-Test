drop table SHAPE if exists;

create table SHAPE(
ENTITY_TYPE	VARCHAR(31)	NOT	NULL,
SHAPE_ID	BIGINT(19)	NOT	NULL AUTO_INCREMENT,
GEOMETRY_DESCRIPTION	VARCHAR(255),
NAME	VARCHAR(255)	,
TYPE	VARCHAR(255)	,
LENGTH	DECIMAL(12)	,
X_COORDINATE	DECIMAL(12),
Y_COORDINATE	DECIMAL(12)
);