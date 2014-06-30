using System;
using System.Drawing;
namespace DFSAlgorithmMaze
{
/// <summary>
/// Summary description for Cell. /// </summary>
	public class Cell
	{
		public static int kCellSize = 30;//迷宫格子(宫格)的大小
		public static int kPadding = 1;//边界大小
		public int[] Walls = new int[4]{1, 1, 1, 1};//每个宫格都可以有四堵墙 public int Row;
		public int Column;
		private static long Seed = DateTime.Now.Ticks;//用当前时间来当随机种子
		static public Random TheRandom = new Random((int)Cell.Seed);//静态变量,只能用类来调用,不能用对象!
		public int Visited = 0;//搜索标记
		public int Pathmark = 0;//路径标记 
		public Cell parent = null;//路径“指针”

		public Cell()
		 {
			//
			// TODO: Add constructor logic here
			//
		}

		public bool HasAllWalls() 
		{
			for (int i = 0; i < 4; i++)
			{
				if (Walls[i] == 0)
				return false;
			}
			return true; 
		}


		public void KnockDownWall(int theWall) 
		{
			Walls[theWall] = 0; 
		}
		public void KnockDownWall(Cell theCell) 
		{
			// find adjacent wall 
			//每次敲墙,其实都要敲两堵——相邻宫格的重合的两堵墙
			int theWallToKnockDown = FindAdjacentWall(theCell); 
			Walls[theWallToKnockDown] = 0;
			int oppositeWall = (theWallToKnockDown + 2) % 4;
			theCell.Walls[oppositeWall] = 0;
		}

		public int FindAdjacentWall(Cell theCell) 
		{
			/* 返回给 walls[]用 *1
			*
			*↑
			*
			*0 ←cell→ 2 *
			*↓
			*
			*3
			*/
			if (theCell.Row == Row) 
			{
				if (theCell.Column < Column) 
				return 0;
				else
				return 2;
			}
			else // columns are the same
			{
				if (theCell.Row < Row)
				return 1;
				else
				return 3;
			} 
		}

		public int GetRandomWall() 
		{
			//墙已经敲开、以及到达四个边界时,再随机改个方向
			int nextWall = TheRandom.Next(0, 3);
			while （ (Walls[nextWall] == 0) || ((Row == 0) && (nextWall == 0)) ||
			((Row == Maze.kDimension - 1) && (nextWall == 2)) || ((Column == 0) && (nextWall == 1)) ||
			((Column == Maze.kDimension - 1) && (nextWall == 3)) )
			{
				nextWall = TheRandom.Next(0, 3); 
			}

			return nextWall;

		}

		public void Draw(Graphics g) 
		{
			Pen fillPen = null;
			fillPen = new Pen( Color.Tomato,2);//画墙的 Pen,颜色为 Tomato,粗度为2
			if (Walls[0] == 1)
			{
				g.DrawLine(fillPen, Row*kCellSize + kPadding, Column*kCellSize + kPadding, (Row+1) * kCellSize + kPadding, Column*kCellSize + kPadding);
			}
			if (Walls[1] == 1)
			{
				g.DrawLine(fillPen,Row*kCellSize +kPadding,Column*kCellSize+ kPadding, Row*kCellSize + kPadding, (Column+1)*kCellSize + kPadding);
			}
			if (Walls[2] == 1)
			{
				g.DrawLine(fillPen, Row*kCellSize + kPadding, (Column+1)*kCellSize + kPadding, (Row+1)*kCellSize + kPadding,(Column+1)*kCellSize + kPadding);
			}
			if (Walls[3] == 1)
			{
				g.DrawLine(fillPen,(Row+1)*kCellSize + kPadding,Column*kCellSize + kPadding, (Row+1)*kCellSize + kPadding, (Column+1)*kCellSize + kPadding);
			}
		}

		public void DrawFill(Graphics g)
		{
			int blank = kCellSize/8;
			SolidBrush fillBrush = new SolidBrush(Color.Tomato);
			g.FillRectangle(fillBrush,Row*kCellSize + kPadding+blank,Column*kCellSize + kPadding+blank,kCellSize-blank*2,kCellSize-blank*2);
			Pathmark = 5;//为路径重绘准备,番茄色
		}

		public void DrawFillSearch(Graphics g) 
		{
			int blank = kCellSize/8;
			SolidBrush fillBrush = new SolidBrush(Color.Gray);
			g.FillRectangle(fillBrush,Row*kCellSize + kPadding+blank, Column*kCellSize + kPadding+blank,kCellSize-blank*2,kCellSize-blank*2);
			Pathmark = 1;//为搜索点重绘准备,灰色
		}

		public void DrawFillNull(Graphics g) 
		{
			int blank = kCellSize/8;
			SolidBrush fillBrush = new SolidBrush(Color.White);
			g.FillRectangle(fillBrush,Row*kCellSize + kPadding+blank,Column*kCellSize + kPadding+blank,kCellSize-blank*2,kCellSize-blank*2);
			Pathmark = 0;//为空白重绘准备,白色
		}
	}
}














