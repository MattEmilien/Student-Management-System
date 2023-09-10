import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";

export function LogoutButton() {
  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button type="button">Sign Out</Button>
      </DialogTrigger>
      <DialogContent className="sm:max-w-[425px]">
        <DialogHeader>
          <DialogTitle>Sign Out</DialogTitle>
          <DialogDescription>
            Are you sure you want to sign out?
          </DialogDescription>
        </DialogHeader>
        <DialogFooter>
          {/* // ! ADD LOGOUT LOGIC HERE */}
          <Button type="submit" variant="destructive">
            Sign Out
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
